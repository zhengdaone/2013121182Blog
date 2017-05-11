 package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.sun.org.apache.xpath.internal.operations.And;




import Tool.JDBCUtils;

import DataBean.Article;
import DataBean.articleType;

public class articleDao {
	Connection connection =null;
	PreparedStatement preparedStatement=null;
	Article article=null;
	public articleDao(){
		connection=JDBCUtils.getConnection();
	}
	public int insertArticle(Article article){
		try {

			String sql="insert into article (title,content,publishTime,typeId,userId) values(?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, article.getTitle());
			preparedStatement.setString(2, article.getContent());
			preparedStatement.setString(3, article.getPublishTime());
			preparedStatement.setInt(4, article.getTypeId());
			preparedStatement.setInt(5, article.getUserId());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			JDBCUtils.release(connection, preparedStatement, null);
		}
	}
  public  Article queryArticle(int articleId) {
		Connection con = JDBCUtils.getConnection(); ;
		PreparedStatement ps = null ;  
		Article article=null;
		ResultSet rs = null;
		String sql = "select * from article where articleId='" + articleId + "'";
		try {
			ps=con.prepareStatement(sql);
			rs = ps.executeQuery(sql);
				while (rs.next()) {
					article= new Article();
					article.setArticleId(rs.getInt(1));			
					article.setTitle(rs.getString(2));
					article.setContent(rs.getString(3));
					article.setPublishTime(rs.getString(4));
					article.setUserId(rs.getInt(5));
					article.setTypeId(rs.getInt(6));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return article;
	}
	public List queryArticleType(int typeId,int userId) {
		List list = new ArrayList();
		String sql = null;
		Connection con = null ; 
		PreparedStatement ps = null ;    
		ResultSet rs = null;
		if (typeId == 0){
			sql = "select * from article";
		}else{
			sql = "select * from article where typeId='" + typeId+ "' and userId='"+userId+"'";
		}
		try {
			con = JDBCUtils.getConnection();
			ps=con.prepareStatement(sql);
				rs = ps.executeQuery(sql);
				while (rs.next()) {
					article= new Article();
					article.setArticleId(rs.getInt(1));
					article.setTitle(rs.getString(2));
					article.setContent(rs.getString(3));
					article.setPublishTime(rs.getString(4));
					article.setTypeId(rs.getInt(5));
					list.add(article);
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(con, ps, rs);
		}
		return list;
	}

  public List selectArticle() {
			List list = new ArrayList();
			Article form = null;
			Connection con = null ; 
			PreparedStatement ps = null ;    
			ResultSet rs = null;  
			try {
				con = JDBCUtils.getConnection();
				String sql = "select articleId,title,content,publishTime,typeId from article";
				ps=con.prepareStatement(sql);
					rs = ps.executeQuery();
					while (rs.next()) {
						form = new Article();
						form.setArticleId(rs.getInt(1));
						form.setTitle(rs.getString(2));
						form.setContent(rs.getString(3));
						form.setPublishTime(rs.getString(4));
						form.setTypeId(rs.getInt(5));
						list.add(form);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBCUtils.release(con, ps, rs);
			}
			return list;
	}
  public List selectArticle2(int friendId) {
		List list = new ArrayList();
		Article article  = null;
		Connection con = null ; 
		PreparedStatement ps = null ;    
		ResultSet rs = null;  
		try {
			con = JDBCUtils.getConnection();
			String sql = "select articleId,title,content,publishTime,typeId from article where userId='"+friendId+"'";
			ps=con.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					article= new Article();
					article.setArticleId(rs.getInt(1));
					article.setTitle(rs.getString(2));
					article.setContent(rs.getString(3));
					article.setPublishTime(rs.getString(4));
					article.setTypeId(rs.getInt(5));
					list.add(article);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(con, ps, rs);
		}
		return list;
}
  public List selectArticle3(Integer userId) {
		List list = new ArrayList();
		Article form = null;
		Connection con = null ; 
		PreparedStatement ps = null ;    
		ResultSet rs = null;  
		try {
			con = JDBCUtils.getConnection();
			String sql = "select articleId,title,content,publishTime,typeId from article where userId='"+userId+"'";
			ps=con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					form = new Article();
					form.setArticleId(rs.getInt(1));
					form.setTitle(rs.getString(2));
					form.setContent(rs.getString(3));
					form.setPublishTime(rs.getString(4));
					form.setTypeId(rs.getInt(5));
					list.add(form);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(con, ps, rs);
		}
		return list;
}
  public List selectArticle5(String searchstr,int userId) {
		List list = new ArrayList();
		Article form = null;
		Connection con = null ; 
		PreparedStatement ps = null ;    
		ResultSet rs = null;  
		try {
			con = JDBCUtils.getConnection();
			String sql = "select articleId,title,content,publishTime,userId,typeId from article where  content like '%"+searchstr+"%' and userId='"+userId+"'";
			ps=con.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					form = new Article();
					form.setArticleId(rs.getInt(1));
					form.setTitle(rs.getString(2));
					form.setContent(rs.getString(3));
					form.setPublishTime(rs.getString(4));
					form.setUserId(rs.getInt(5));
					form.setTypeId(rs.getInt(6));
					list.add(form);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(con, ps, rs);
		}
		return list;
}
  public int deleteArticle(int articleId){
	  Connection conn=null;
	  PreparedStatement pstmt=null;
	  try {
		String sql="delete from article where articleId='" + articleId+ "'";
		  conn=JDBCUtils.getConnection();
		  pstmt=conn.prepareStatement(sql);
		  int rtn=pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		JDBCUtils.release(conn, pstmt, null);
	}
	return 0;
	  
  }
  public int updateArticle(Article article){
	  Connection conn=null;
	  PreparedStatement pstmt=null;
	  int articleId=article.getArticleId();
	  try {
			String sql="update article set title=?,content=?,publishTime=?,typeId=? where articleId='" + articleId+ "'";
			conn=JDBCUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContent());
			pstmt.setString(3, article.getPublishTime());
			pstmt.setInt(4, article.getTypeId());
			int rtn=pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		JDBCUtils.release(conn, pstmt, null);
	}
	return 0;	  
  }
	
}
