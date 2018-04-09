package org.kosta.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.kosta.model.VO.ProgramImgVO;
import org.kosta.model.VO.ProgramVO;
import org.kosta.model.etc.DataSourceManager;
import org.kosta.model.etc.PagingBean;

public class ProgramDAO {
	private static ProgramDAO dao = new ProgramDAO();
	private DataSource datasource;

	public ProgramDAO() {
		datasource=DataSourceManager.getInstance().getDataSource();
	}
	public static ProgramDAO getInstance(){
		return dao;
	}
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		closeAll(null, pstmt, con);
	}
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
	public String addProgram(String programName, String programDetail) throws SQLException { 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String progNo= null;
		try {
			con = datasource.getConnection();
			String sql ="insert into yoga_program(programNo, programName, programDetail) values(prgNo_seq.nextval,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, programName);
			pstmt.setString(2, programDetail);
			pstmt.executeUpdate();
			pstmt.close();
			sql="select prgNo_seq.currval from dual";
			pstmt=con.prepareStatement(sql);
			pstmt.executeQuery();
			rs=pstmt.executeQuery();
			if(rs.next()) {
				progNo=rs.getString(1);
			}	
		}finally {
			closeAll(pstmt, con);
		}
		return progNo;
	}
	// 강좌 추가 할 때 사용하는 프로그램 리스트
	public ArrayList<ProgramVO> getProgramList() throws SQLException {
		ArrayList<ProgramVO> list = new ArrayList<ProgramVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = datasource.getConnection();
			String sql = "select programNo,programName,programDetail from yoga_program";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProgramVO vo=new ProgramVO();
				vo.setProgramNo(rs.getString(1));
				vo.setProgramName(rs.getString(2));
				vo.setProgramDetail(rs.getString(3));
				list.add(vo);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	// 페이징 할 때 사용하는 프로그램 리스트
	public ArrayList<ProgramVO> getProgramList(PagingBean pagingBean) throws SQLException {
		ArrayList<ProgramVO> list = new ArrayList<ProgramVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = datasource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("select programNo, programName from( ");
			sql.append("select  row_number() over(order by programNo asc) ");
			sql.append("as rnum, programNo, programName from yoga_program) ");
			sql.append("where rnum between ? and ?");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setInt(1, pagingBean.getStartRowNumber());
			pstmt.setInt(2, pagingBean.getEndRowNumber());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ProgramVO(rs.getString(1), rs.getString(2)));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	// 프로그램 디테일 출력
	public ProgramVO getProgramListByNo(int programNo) throws SQLException {
		ProgramVO vo=null;
		ProgramImgVO programImgVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = datasource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("select p.programno, p.programName, p.programDetail, pi.hitCount, pi.imgUrl1, pi.imgUrl2, pi.imgUrl3, pi.imgUrl4 ");
			sql.append("from yoga_programImg pi, yoga_program p ");
			sql.append("where pi.programImg=p.programno and programno=?");
			pstmt=con.prepareStatement(sql.toString());	
			pstmt.setInt(1, programNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				programImgVO = new ProgramImgVO(rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
				vo = new ProgramVO(rs.getString(1), rs.getString(2), rs.getString(3), programImgVO);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
	//관리자용 읽어오기 입니다. 제발 건들지말아주세요ㅠㅠㅠ
	public ProgramVO getProgramListByNoUseByMA(int programNo) throws SQLException {
		ProgramVO vo=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = datasource.getConnection();
			String sql = "select programNo,programName,programDetail from yoga_program where programNo=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, programNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new ProgramVO(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
	
	public int getProgramListTotal() throws SQLException {
		int count=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = datasource.getConnection();
			String sql = "select count(*) from yoga_program";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}finally {
			closeAll(pstmt, con);
		}
		return count;
	}
	
	public String getProgramNoByName(String programName) throws SQLException {
		String pNo=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = datasource.getConnection();
			String sql = "select programNo from YOGA_PROGRAM where programName=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, programName);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pNo = rs.getString(1);
			}
		}finally {
			closeAll(pstmt, con);
		}
		return pNo;
	}
	public void addProgramImg(String programHit, String imgURL1, String imgURL2, String imgURL3, String imgURL4) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = datasource.getConnection();
			String sql ="insert into yoga_programImg(programImg, hitCount, imgUrl1, imgUrl2, imgUrl3, imgUrl4) values(programImg_seq.nextval, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, programHit);
			pstmt.setString(2, imgURL1);
			pstmt.setString(3, imgURL2);
			pstmt.setString(4, imgURL3);
			pstmt.setString(5, imgURL4);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
}
