package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataBean.pReply;
import Tool.JDBCUtils;

public class pReplyDao {
	public int insertpReply(pReply pReply ){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			String sql="insert into pReply (pCommentId,reContent,reUser) values(?,?,?)";
			connection=JDBCUtils.getConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, pReply.getpCommentId());
			preparedStatement.setString(2, pReply.getReContent());
			preparedStatement.setString(3, pReply.getReUser());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			JDBCUtils.release(connection, preparedStatement, null);
		}
	}
	public List selectpReply(Integer pCommentId){
		List list=new ArrayList();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		pReply pReply=null;
		try {
			connection=JDBCUtils.getConnection();
			String sql="select * from preply where pCommentId='"+pCommentId+"'";
			preparedStatement=connection.prepareStatement(sql);
			rs=preparedStatement.executeQuery();
			while (rs.next()) {
				pReply=new pReply();
				pReply.setpReplyId(rs.getInt(1));
				pReply.setpCommentId(rs.getInt(2));
				pReply.setReContent(rs.getString(3));
				pReply.setReUser(rs.getString(4));
				list.add(pReply);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(connection, preparedStatement, rs);
		}
		return list;
	}
}
