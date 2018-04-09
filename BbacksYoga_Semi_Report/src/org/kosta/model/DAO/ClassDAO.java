package org.kosta.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.kosta.model.VO.ClassVO;
import org.kosta.model.VO.ProgramVO;
import org.kosta.model.VO.TeacherVO;
import org.kosta.model.etc.DataSourceManager;


public class ClassDAO {
	private static ClassDAO dao=new ClassDAO();
	private DataSource dataSource;
	private ClassDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static ClassDAO getInstance(){		
		return dao;
	}	
	public void closeAll(PreparedStatement pstmt,
			Connection con) throws SQLException{
		closeAll(null,pstmt,con);
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,
			Connection con) throws SQLException{
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
	public String createClass(String teacherId, String programId, String day, String time, String capacity) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		String classNo=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="insert into yoga_class values(class_seq.nextval,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, programId);
			pstmt.setString(2, teacherId);
			pstmt.setString(3, capacity);
			pstmt.setString(4, time);
			pstmt.setString(5, day);
			pstmt.executeUpdate();	
			pstmt.close();
			sql="select class_seq.currval from dual";
			pstmt=con.prepareStatement(sql);
			pstmt.executeQuery();
			rs=pstmt.executeQuery();
			if(rs.next()) {
				classNo=rs.getString(1);
			}	
		}finally {
			closeAll(pstmt, con);
		}	
		return classNo;
	}
	public ArrayList<String> getClassListById(String teacherId) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<String> list=new ArrayList<String>();
		try {
			con=dataSource.getConnection();
			String sql="select p.programName from yoga_class c, YOGA_PROGRAM p where c.programno=p.programno and teacherid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, teacherId);
			rs=pstmt.executeQuery();
			while(rs.next())
				list.add(rs.getString(1));
		}finally {
			closeAll(rs,pstmt, con);
		}
		return list;
	}
	
	public ClassVO getClassById(String classId) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ClassVO classVo=null;
		try {
			System.out.println("dao"+classId);
			con=dataSource.getConnection();
			String sql="select c.programNo, c.teacherid, c.classtime,c.classDay from yoga_class c where classno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(classId));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				TeacherVO teacher = TeacherDAO.getInstance().getTeacherInfobyId(rs.getString(2));
				ProgramVO program= ProgramDAO.getInstance().getProgramListByNoUseByMA(Integer.parseInt(rs.getString(1)));
				classVo = new ClassVO(teacher, program, rs.getString(3), rs.getString(4));
			}
		}finally {
			closeAll(rs,pstmt, con);
		}
		System.out.println(classVo.toString());
		
		return classVo;
	}
	public ArrayList<ClassVO> getClassList() throws SQLException {
		//class전체 받아오기
		ClassVO classVo = null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ClassVO> classList=new ArrayList<ClassVO>();
		try {
			con=dataSource.getConnection();
			String sql="select p.programno, c.teacherid, c.classDay, c.classTime from yoga_class c, YOGA_PROGRAM p where c.programno=p.programno";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ProgramVO program= ProgramDAO.getInstance().getProgramListByNoUseByMA(rs.getInt(1));
				TeacherVO teacher = TeacherDAO.getInstance().getTeacherInfobyId(rs.getString(2));
				classVo= new ClassVO(teacher, program,rs.getString(3),rs.getString(4));
				classList.add(classVo);
			}	
		}finally {
			closeAll(rs,pstmt, con);
		}
		return classList;
	}
	public void deleteClass() throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="delete from yoga_class";
			pstmt=con.prepareStatement(sql);
			pstmt.executeUpdate();

		}finally {
			closeAll(pstmt, con);
		}
	}
	//중복 인서트를 막기위해 가능한 시간을 찾는다
	public ArrayList<String> getAvailableTime(String teacher, String program, String day) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<String> timeList=new ArrayList<String>();
		try {
			con=dataSource.getConnection();
			String sql="select classTime from YOGA_CLASS where classDay=? and programNo=? and teacherId=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, day);
			pstmt.setString(2, program);
			pstmt.setString(3, teacher);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String temp=rs.getString(1);
				timeList.add(temp);
			}	
		}finally {
			closeAll(rs,pstmt, con);
		}
		return timeList;
	}

}
