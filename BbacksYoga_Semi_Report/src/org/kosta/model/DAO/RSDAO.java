package org.kosta.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.kosta.model.DAO.RSDAO;
import org.kosta.model.VO.RSVO;

public class RSDAO {
	private static RSDAO instance=new RSDAO();
	private RSDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		
		return DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
	}
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public void closeAll(ResultSet RS, PreparedStatement pstmt, Connection con) throws SQLException {
		if (RS != null)
			RS.close();
		closeAll(pstmt, con);
	}
	
	public static RSDAO getInstance() {
		return instance;
	}

	public ArrayList<RSVO> readTimetableInfo() throws ClassNotFoundException, SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet RS=null;
		ArrayList<RSVO> list=new ArrayList<RSVO>();
		
		try {
			con=getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("select prg.programName, tch.teacherNick, cls.classNo, cls.classTime, cls.classDay, cls.capacity ");
			sql.append(" from yoga_program prg, yoga_teacher tch, yoga_class cls ");
			sql.append(" where cls.programNo=prg.programNo and cls.teacherId=tch.teacherId order by cls.classNo asc");
			ps=con.prepareStatement(sql.toString());
			RS=ps.executeQuery();
			while(RS.next()) {
				list.add(new RSVO(RS.getString(1), RS.getString(2), RS.getInt(3), RS.getInt(4), RS.getString(5), RS.getInt(6)));
			}
			ps.close();
			RS.close();
			
			StringBuilder sql2=new StringBuilder();
			sql2.append("select cls.classNo, count(reg.classNo) from registeRStatus reg, YOGA_CLASS cls, YOGA_MEMBER mem ");
			sql2.append(" where reg.classNo=cls.classNo and reg.id=mem.id group by cls.classNo");
			ps=con.prepareStatement(sql2.toString());
			RS=ps.executeQuery();
			while(RS.next()) {
				for(int i=0; i<list.size(); i++) {
					if(list.get(i).getClassNo()==RS.getInt(1)) {
						list.get(i).setCount_reg(RS.getInt(2));
						break;
					}
				}
			}
		}finally {
			closeAll(RS, ps, con);
		}
		
		return list;
	}

	public boolean RegisterClass(String classNo, String userId) throws ClassNotFoundException, SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet RS=null;
		
		try {
			con=getConnection();
			String sql="select RSNo from registeRStatus where classNo=? and id=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(classNo));
			ps.setString(2, userId);
			RS=ps.executeQuery();
			if(RS.next())
				return false;
			
			ps.close();
			sql="insert into registeRStatus(RSNo, classNo, id, regDate) values(RS_seq.nextVal, ?, ?, sysdate)";
			ps=con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(classNo));
			ps.setString(2, userId);
			ps.executeUpdate();
			ps.close();
			
			sql="update yoga_member set member_status=member_status-1 where id=?";
	         ps=con.prepareStatement(sql);
	         ps.setString(1, userId);
	         ps.executeUpdate();
	         
		}finally {
			closeAll(RS,ps,con);
		}
		return true;
	}

	public void NewRegisterClass(String classNo, String userId) throws ClassNotFoundException, SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=getConnection();
			String sql="insert into registerStatus(RSNo, classNo, id, regDate) values(RS_seq.nextVal, ?, ?, sysdate)";
			ps=con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(classNo));
			ps.setString(2, userId);
			ps.executeUpdate();
			ps.close();
			
			sql="update yoga_member set member_status=member_status-1 where id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.executeUpdate();
					
		}finally {
			closeAll(rs,ps,con);
		}
	}
	public boolean Check_OverlapByClassNo(String classNo, String userId) throws ClassNotFoundException, SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean flag=true;
		System.out.println(classNo+", "+userId);
		try {
			con=getConnection();
			String sql="select RSNo from registeRStatus where classNo=? and id=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(classNo));
			ps.setString(2, userId);
			rs=ps.executeQuery();
			if(rs.next())
				flag=false;	
		}finally {
			closeAll(rs,ps,con);
		}
		return flag;
	}
	
	public void Delete_RegisterClass(String userId, Integer classNo) throws ClassNotFoundException, SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=getConnection();
			String sql="delete from registeRStatus where id=? and classNo=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, classNo);
			ps.executeUpdate();
			ps.close();
	         
	         sql="update yoga_member set member_status=member_status+1 where id=?";
	         ps=con.prepareStatement(sql);
	         ps.setString(1, userId);
	         ps.executeUpdate();
			
		}finally {
			closeAll(ps,con);
		}
		
	}

	public ArrayList<RSVO> Read_RegisteRStatus(String userId) throws ClassNotFoundException, SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet RS=null;
		ArrayList<RSVO> list=new ArrayList<RSVO>();
		
		try {
			con=getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("select prg.programName, tch.teacherNick, cls.classTime, cls.classDay, to_char(reg.regDate,'YY/MM/DD'), reg.classNo ");
			sql.append(" from YOGA_PROGRAM prg, YOGA_TEACHER tch, YOGA_CLASS cls, REGISTERSTATUS reg ");
			sql.append(" where reg.id=? and reg.classNo=cls.classNo and prg.programNo=cls.programNo and tch.teacherId=cls.teacherId ");
			ps=con.prepareStatement(sql.toString());
			ps.setString(1, userId);
			RS=ps.executeQuery();
			while(RS.next()) {
				list.add(new RSVO(RS.getString(1), RS.getString(2), RS.getInt(3), RS.getString(4), RS.getString(5), RS.getInt(6)));
			}
		}finally {
			closeAll(RS,ps,con);
		}
		return list;
	}

	public int readUserPackage(String userId) throws ClassNotFoundException, SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet RS=null;
		int userPackage=0;
	    
	      try {
	         con=getConnection();
	         String sql="select member_status from yoga_member where id=?";
	         ps=con.prepareStatement(sql);
	         ps.setString(1, userId);
	         RS=ps.executeQuery();
	         if(RS.next()) 
	            userPackage= Integer.parseInt(RS.getString(1));
	      }finally {
	         closeAll(RS,ps,con);
	      }
	      return userPackage;
	   }
}
