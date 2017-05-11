package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import DataBean.Friend;
import DataBean.articleType;
import Tool.JDBCUtils;

public class friendDao {
	public int inserfriend(Friend friend){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql="insert into friend (friendId,fName,userId) values(?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, friend.getFriendId());
			pstmt.setString(2, friend.getfName());
			pstmt.setInt(3, friend.getUserId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			JDBCUtils.release(conn, pstmt, null); 
		}	
	}
	public List queryFriend(Integer userId) {
		List list = new ArrayList();
		Friend friend = null;
		Connection con = null ; 
		PreparedStatement ps = null ;    
		ResultSet rs = null;  
		try {
			con = JDBCUtils.getConnection();
			String sql = "select id,friendId,fName from friend where userId='"+userId+"'";
			ps=con.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					friend = new Friend();
					friend.setId(rs.getInt(1));
					friend.setFriendId(rs.getInt(2));
					friend.setfName(rs.getString(3));
					list.add(friend);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(con, ps, rs);
		}
		return list;

}
	public int deleteFriend(int id){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			connection=JDBCUtils.getConnection();
			String sql="delete from friend where id='"+id+"'";
			preparedStatement=connection.prepareStatement(sql);
			int rtn=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(connection, preparedStatement, null);
		}
		return 0;
		
	}
}
