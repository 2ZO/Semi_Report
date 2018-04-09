package org.kosta.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.kosta.model.VO.ProgramVO;
import org.kosta.model.VO.TeacherVO;
import org.kosta.model.etc.DataSourceManager;

public class TeacherDAO {
	private static TeacherDAO instance = new TeacherDAO();
	private DataSource dataSource;

	private TeacherDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static TeacherDAO getInstance() {
		return instance;
	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		closeAll(null, pstmt, con);
	}

	// 추가 후 시퀸스 돌려줌
	public String AddTeacher(String name, String nick, String profile, String imgURL) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String id = null;
		try {
			con = dataSource.getConnection();
			String sql = "insert into yoga_teacher(teacherId,teacherName,teacherNick,teacherProfile,imgUrl) values(tchNo_seq.nextval,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, nick);
			pstmt.setString(3, profile);
			pstmt.setString(4, imgURL);
			pstmt.executeUpdate();
			pstmt.close();
			sql = "select tchNo_seq.currval from dual";
			pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
			rs = pstmt.executeQuery();
			if (rs.next()) {
				id = rs.getString(1);
			}
		} finally {
			closeAll(pstmt, con);
		}
		return id;
	}

	public ArrayList<TeacherVO> getTeacherList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TeacherVO> list = new ArrayList<TeacherVO>();
		try {
			con = dataSource.getConnection();
			String sql = "select teacherId, teacherName, teacherNick, teacherProfile ,imgUrl  from yoga_teacher";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next())
				list.add(new TeacherVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)));
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	public TeacherVO getTeacherInfobyId(String teacherId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TeacherVO tvo = null;
		try {
			con = dataSource.getConnection();
			String sql = "select teacherId, teacherName, teacherNick, teacherProfile ,imgUrl  from yoga_teacher where teacherId=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, teacherId);
			rs = pstmt.executeQuery();
			while (rs.next())
				tvo = new TeacherVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
		} finally {
			closeAll(rs, pstmt, con);
		}
		return tvo;
	}

	// 관리자용, 이름으로 아이디 찾기
	public String getTeacherNoByName(String teacher) throws SQLException {
		String tNo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select teacherId from YOGA_TEACHER where teacherName=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, teacher);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				tNo = rs.getString(1);
			}
		} finally {
			closeAll(pstmt, con);
		}
		return tNo;
	}

}