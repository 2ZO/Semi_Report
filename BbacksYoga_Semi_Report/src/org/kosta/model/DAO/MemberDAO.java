package org.kosta.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.kosta.model.VO.MemberVO;
import org.kosta.model.etc.DataSourceManager;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
	 
public class MemberDAO {
	private static MemberDAO dao=new MemberDAO();
	private DataSource dataSource;
	private MemberDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static MemberDAO getInstance(){		
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
	
	public MemberVO LogIn(String id, String password) throws SQLException {
		MemberVO member=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=dataSource.getConnection();
			String sql="select name from yoga_member where id=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()){
				member= new MemberVO(id, rs.getString(1));
			}
		}finally{
			closeAll(rs, pstmt,con);
		}
		return member;	
	}
	public MemberVO checkMyinfoById(String id, String password) throws SQLException {
		MemberVO member=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=dataSource.getConnection();
			String sql="select password,name,phone_number,address,email,password_question,password_answer,regDate,member_status,class_package from yoga_member where id=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()){
				member= new MemberVO(id, rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
			}
		}finally{
			closeAll(rs, pstmt,con);
		}
		return member;	
		
	}
	
	//회원가입 때 아이디중복체크
	public boolean getMemberById(String id) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag= true;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;	
		try{
			con=dataSource.getConnection();
			String sql="select id from yoga_member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				flag=false;
			}
		}finally{
			closeAll(rs, pstmt,con);
		}
		return flag;
	}
	
	//회원가입 때 이메일 중복 체크
	public boolean getMemberByEmail(String email) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag= true;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;	
		try{
			con=dataSource.getConnection();
			String sql="select id from yoga_member where email=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs=pstmt.executeQuery();
			if(rs.next()){
				flag=false;
			}
		}finally{
			closeAll(rs, pstmt,con);
		}
		return flag;
	}
	//회원가입
	public void createMember(MemberVO vo) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(vo.toString());
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;	
		try{
			con=dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("insert into yoga_member(id,password,name,phone_number,address,email,password_question,");
			sb.append("password_answer,regDate,member_status,class_package) ");
			sb.append("values(?,?,?,?,?,?,?,?,sysdate,?,?)");
			
			pstmt=con.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone_number());
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getEmail());
			pstmt.setString(7, vo.getPassword_question());
			pstmt.setString(8, vo.getPassword_answer());
			pstmt.setString(9, vo.getClass_package());
			pstmt.setString(10, vo.getClass_package());
			rs=pstmt.executeQuery();

		}finally{
			closeAll(rs, pstmt,con);
		}
	}
	public void updateMyInfo(MemberVO vo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("update yoga_member set password=?, phone_number=?, address=? ,email=?, password_question=?,");
			sb.append("password_answer=?, name=? where id=?");
			pstmt=con.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getPhone_number());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPassword_question());
			pstmt.setString(6, vo.getPassword_answer());
			pstmt.setString(7, vo.getName());
			pstmt.setString(8, vo.getId());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	public ArrayList<MemberVO> getPasswordById(String id) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;	
		try{
			con=dataSource.getConnection();
			String sql="select password from yoga_member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				list.add(new MemberVO(id, rs.getString(1), null, null, null, null, null, null, null, null, null));
			}
		}finally{
			closeAll(rs, pstmt,con);
		}
		return list;
	}
}
