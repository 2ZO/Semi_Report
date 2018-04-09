package org.kosta.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;


import org.kosta.model.VO.PostVO;
import org.kosta.model.etc.DataSourceManager;
import org.kosta.model.etc.PagingBean;

public class PostDAO {
	/*선화쨩을 위한 싱글톤과 커넥션풀*/
	private static PostDAO dao=new PostDAO();
	private DataSource dataSource;
	private PostDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static PostDAO getInstance(){		
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
	public void createPost(String title, String content, String id) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="insert into post values(post_seq.nextval,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}		
	}
	public ArrayList<PostVO> getPostingList(PagingBean pb) throws SQLException {
		ArrayList<PostVO> list=new ArrayList<PostVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("select postNo,title,id,to_char(regDate,'YYYY.MM.DD') from ( ");
			sql.append("select  row_number() over(order by postNo desc) ");
			sql.append("as rnum,postNo,title,id,regDate from post)");
			sql.append("where rnum between ? and ?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, pb.getStartRowNumber());
			pstmt.setInt(2, pb.getEndRowNumber());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				PostVO pvo=new PostVO();
				pvo.setPostNo(rs.getString(1));
				pvo.setTitle(rs.getString(2));
				pvo.setId(rs.getString(3));
				pvo.setRegDate(rs.getString(4));
				list.add(pvo);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	public int getTotalPostCount() throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=dataSource.getConnection();
			String sql="select count(*) from post";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
				count=rs.getInt(1);
		}finally {
			closeAll(rs, pstmt, con);
		}
		return count;
	}
	public PostVO getPostDetailByPostNo(String postNo) throws SQLException {
		// TODO Auto-generated method stub
		PostVO post = null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="select title,content,id,regDate from post where postNo=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(postNo));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				post = new PostVO(postNo, rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return post;
	}
	public void UpdatePost(String postNo, String postTitle, String postContent) throws NumberFormatException, SQLException {
				Connection con=null;
				PreparedStatement pstmt=null;
				try {
					con=dataSource.getConnection();
					String sql="update post set title=?, content=? where postno=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, postTitle);
					pstmt.setString(2, postContent);
					pstmt.setString(3, postNo);
					pstmt.executeUpdate();
				}finally {
					closeAll( pstmt, con);
				}
		
	}
	public void deletePost(String postNo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="delete post where postno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, postNo);
			pstmt.executeUpdate();
		}finally {
			closeAll( pstmt, con);
		}		
	}
	public ArrayList<PostVO> getPostSearch(String opt,String keyword,PagingBean pb) throws SQLException {
		ArrayList<PostVO> list=new ArrayList<PostVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String temp = "%"+keyword+"%";
		int option= Integer.parseInt(opt);
		try {
			con=dataSource.getConnection();
			if(option==0) {//제목을 선택한 검색
				StringBuilder sql=new StringBuilder();
				sql.append("select postNo,title,id,to_char(regDate,'YYYY.MM.DD') ");
				sql.append("from ( select  row_number() over(order by postNo desc) ");
				sql.append("as rnum,postNo,title,id,regDate from (SELECT * ");
				sql.append("FROM POST WHERE title LIKE ?)) ");
				sql.append("where rnum between ? and ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, temp);
				pstmt.setInt(2, pb.getStartRowNumber());
				pstmt.setInt(3, pb.getEndRowNumber());
			}else if(option==1) {//작성자(id)를 선택한 검색
				StringBuilder sql=new StringBuilder();
				sql.append("select postNo,title,id,to_char(regDate,'YYYY.MM.DD') ");
				sql.append("from ( select  row_number() over(order by postNo desc) ");
				sql.append("as rnum,postNo,title,id,regDate from (SELECT * ");
				sql.append("FROM POST WHERE id LIKE ?)) ");
				sql.append("where rnum between ? and ?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, temp);
				pstmt.setInt(2, pb.getStartRowNumber());
				pstmt.setInt(3, pb.getEndRowNumber());
				System.out.println(pb.getStartRowNumber());
				System.out.println(pb.getEndRowNumber());
			}
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new PostVO(rs.getString(1),rs.getString(2),null,rs.getString(3),rs.getString(4)));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	public int getTotalSearchPostCount(String opt, String keyword) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		String temp = "%"+keyword+"%";
		int option= Integer.parseInt(opt);
		try {
			con=dataSource.getConnection();
			if(option==0) {//제목을 선택한 검색
				String sql="SELECT count(*) FROM POST WHERE title LIKE ?";
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, temp);
			}else if(option==1) {
				String sql="SELECT count(*) FROM POST WHERE id LIKE ?";
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, temp);
			}
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return count;
	}
}
