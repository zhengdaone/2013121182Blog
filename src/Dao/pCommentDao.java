package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataBean.Comment;
import DataBean.pComment;
import Tool.JDBCUtils;

public class pCommentDao {
	public int insertpComment(pComment pcomment){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="insert into pcomment (comContent,photoId,fName) values(?,?,?)";			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pcomment.getComContent());
			pstmt.setInt(2, pcomment.getPhotoId());
			pstmt.setString(3, pcomment.getfName());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(conn, pstmt, null);
		}
		return 0;		
	}
	public List selectpComment(Integer photoId){
		List list=new ArrayList();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select pCommentId,comContent,fName,photoId from pcomment where photoId='"+photoId+"'";
			conn=JDBCUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				pComment comment =new pComment();
				comment.setpCommentId(rs.getInt(1));
				comment.setComContent(rs.getString(2));
				comment.setfName(rs.getString(3));
				comment.setPhotoId(rs.getInt(4));			
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
	public pComment selectComment2(Integer pCommentId){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		pComment comment=null;
		try {
			String sql="select comContent,fName,pCommentId,photoId from pcomment where pCommentId='"+pCommentId+"'";
			conn=JDBCUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
			comment=new pComment();
			comment.setComContent(rs.getString(1));
			comment.setfName(rs.getString(2));
			comment.setpCommentId(rs.getInt(3));
			comment.setPhotoId(rs.getInt(4));
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
