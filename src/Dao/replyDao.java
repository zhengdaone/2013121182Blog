package Dao;

import java.sql.*;
import java.util.*;

import Tool.JDBCUtils;

import DataBean.Reply;

public class replyDao {
	public int insertReply(Reply reply ){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			String sql="insert into reply (commentId,reContent,reUser) values(?,?,?)";
			connection=JDBCUtils.getConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, reply.getCommentId());
			preparedStatement.setString(2, reply.getReContent());
			preparedStatement.setString(3, reply.getReUser());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			JDBCUtils.release(connection, preparedStatement, null);
		}
	}
	public List selectReply(Integer commentId){
		List list=new ArrayList();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		Reply reply=null;
		try {
			connection=JDBCUtils.getConnection();
			String sql="select * from reply where commentId='"+commentId+"'";
			preparedStatement=connection.prepareStatement(sql);
			rs=preparedStatement.executeQuery();
			while (rs.next()) {
				reply=new Reply();
				reply.setReplyId(rs.getInt(1));
				reply.setCommentId(rs.getInt(2));
				reply.setReContent(rs.getString(3));
				reply.setReUser(rs.getString(4));
				list.add(reply);		
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
