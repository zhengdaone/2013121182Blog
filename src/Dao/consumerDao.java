package Dao;

import java.sql.*;
import java.util.List;

import DataBean.Article;
import DataBean.Consumer;
import Tool.JDBCUtils;

public class consumerDao {
	public int inserConsumer(Consumer consumer){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="insert into consumer (username,password,sex,email,registerTime) values(?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, consumer.getUsername());
			pstmt.setString(2, consumer.getPassword());
			pstmt.setString(3, consumer.getSex());
			pstmt.setString(4, consumer.getEmail());
			pstmt.setString(5, consumer.getRegisterTime());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			JDBCUtils.release(conn, pstmt, null); 
		}
		
	}
	public int updateConsumer(Consumer consumer){
		Connection conn=null;
		PreparedStatement pstmt=null;
		int userId=consumer.getUserId();
		try {
			conn=JDBCUtils.getConnection();
			String sql="update consumer set username=?,password=?,sex=?,email=? where userId='"+userId+"'";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, consumer.getUsername());
			pstmt.setString(2, consumer.getPassword());
			pstmt.setString(3, consumer.getSex());
			pstmt.setString(4, consumer.getEmail());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			JDBCUtils.release(conn, pstmt, null);
		}
	}
	public Consumer selectUser(String username){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Consumer consumer=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="select username,password,userId from consumer where username='"+username+"'";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
			    consumer=new Consumer();
				consumer.setUsername(rs.getString(1));
				consumer.setPassword(rs.getString(2));
				consumer.setUserId(rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(conn, pstmt, rs);
		}
		return consumer;
	}
}
