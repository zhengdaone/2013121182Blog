package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import Tool.JDBCUtils;

import DataBean.Comment;

public class commentDao {
	public int insertComment(Comment comment){
		Connection conn=null;
		PreparedStatement pstmt=null;
		Statement statement=null;
		try {
			conn=JDBCUtils.getConnection();		
			String sql="insert into comment (comContent,articleId,fName) values(?,?,?)";		
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, comment.getComContent());
			pstmt.setInt(2, comment.getArticleId());
			pstmt.setString(3, comment.getfName());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(conn, pstmt, null);
		}
		return 0;
		
	}
	
	public List selectComment(Integer articleId){
		List list=new ArrayList();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select comContent,fName,commentId from comment where articleId='"+articleId+"'";
			conn=JDBCUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Comment comment =new Comment();
				comment.setComContent(rs.getString(1));
				comment.setfName(rs.getString(2));
				comment.setCommentId(rs.getInt(3));
				list.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(conn, pstmt, rs);
		}
		return list;
	}
	public Comment selectComment2(Integer commentId){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Comment comment=null;
		try {
			String sql="select comContent,fName,commentId,articleId from comment where commentId='"+commentId+"'";
			conn=JDBCUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
			comment=new Comment();
			comment.setComContent(rs.getString(1));
			comment.setfName(rs.getString(2));
			comment.setCommentId(rs.getInt(3));
			comment.setArticleId(rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(conn, pstmt, rs);
		}
		return comment;
	}
	public Comment selectComment3(Integer articleId){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Comment comment =null;
		try {
			String sql="select comContent,fName,commentId from comment where articleId='"+articleId+"'";
			conn=JDBCUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				comment =new Comment();
				comment.setComContent(rs.getString(1));
				comment.setfName(rs.getString(2));
				comment.setCommentId(rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(conn, pstmt, rs);
		}
		return comment;
	}
	
}
