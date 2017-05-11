package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspsmart.upload.File;
import com.sun.crypto.provider.RSACipher;

import Tool.JDBCUtils;

import DataBean.Photo;

public class photoDao {
	public int insertPhoto(Photo photo){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			connection=JDBCUtils.getConnection();
			String sql="insert into photo (photoAddress,photoTime,pTypeId,userId) values(?,?,?,?)";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, photo.getPhotoAddress());
			preparedStatement.setString(2, photo.getPhotoTime());
			preparedStatement.setInt(3, photo.getpTypeId());
			preparedStatement.setInt(4, photo.getUserId());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			JDBCUtils.release(connection, preparedStatement, null);
		}
	}
	public int insertPhoto1(Photo photo){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			connection=JDBCUtils.getConnection();
			String sql="insert into photo (photoAddress,photoTime,pTypeId,userId,articleId) values(?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, photo.getPhotoAddress());
			preparedStatement.setString(2, photo.getPhotoTime());
			preparedStatement.setInt(3, photo.getpTypeId());
			preparedStatement.setInt(4, photo.getUserId());
			preparedStatement.setInt(5, photo.getArticleId());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			JDBCUtils.release(connection, preparedStatement, null);
		}
	}
	public Integer MaxQueryID() {
		Integer maxID = 0;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		try {
			connection=JDBCUtils.getConnection();
			String sql = "select max(photoId) as photoId from photo";
			preparedStatement=connection.prepareStatement(sql);
		    rs = preparedStatement.executeQuery();
			while (rs.next()) {
					maxID = rs.getInt("photoId");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(connection, preparedStatement, rs);
		}
		return maxID;
	}
	public int deletePhoto(int photoId){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			connection=JDBCUtils.getConnection();
			String sql="delete from photo where photoId='"+photoId+"'";
			preparedStatement=connection.prepareStatement(sql);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			JDBCUtils.release(connection, preparedStatement, null);
		}
		
	}

public List selectPhoto(int userId){
	List list =new ArrayList();
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	Photo photo=null;
	try {
		connection=JDBCUtils.getConnection();
		String sql="select * from photo where userId='"+userId+"'";
		preparedStatement=connection.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			photo=new Photo();
			photo.setPhotoId(resultSet.getInt(1));
			photo.setPhotoAddress(resultSet.getString(2));
			photo.setPhotoTime(resultSet.getString(3));
			photo.setpTypeId(resultSet.getInt(4));
			photo.setUserId(resultSet.getInt(5));
			photo.setArticleId(resultSet.getInt(6));
			list.add(photo);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		JDBCUtils.release(connection, preparedStatement, resultSet);
	}
	return list;
}
public List selectPhoto2(int pTypeId){
	List list =new ArrayList();
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	Photo photo=null;
	try {
		connection=JDBCUtils.getConnection();
		String sql="select * from photo where pTypeId='"+pTypeId+"'";
		preparedStatement=connection.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			photo=new Photo();
			photo.setPhotoId(resultSet.getInt(1));
			photo.setPhotoAddress(resultSet.getString(2));
			photo.setPhotoTime(resultSet.getString(3));
			photo.setpTypeId(resultSet.getInt(4));
			photo.setUserId(resultSet.getInt(5));
			photo.setArticleId(resultSet.getInt(6));
			list.add(photo);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		JDBCUtils.release(connection, preparedStatement, resultSet);
	}
	return list;
}
public List selectPhoto5(int pTypeId,int userId){
	List list =new ArrayList();
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	Photo photo=null;
	try {
		connection=JDBCUtils.getConnection();
		String sql="select * from photo where pTypeId='"+pTypeId+"' and userId='"+userId+"'";
		preparedStatement=connection.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			photo=new Photo();
			photo.setPhotoId(resultSet.getInt(1));
			photo.setPhotoAddress(resultSet.getString(2));
			photo.setPhotoTime(resultSet.getString(3));
			photo.setpTypeId(resultSet.getInt(4));
			photo.setUserId(resultSet.getInt(5));
			photo.setArticleId(resultSet.getInt(6));
			list.add(photo);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		JDBCUtils.release(connection, preparedStatement, resultSet);
	}
	return list;
}
public Photo selectPhoto1(int photoId){
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	Photo photo=null;
	try {
		connection=JDBCUtils.getConnection();
		String sql="select * from photo where photoId='"+photoId+"'";
		preparedStatement=connection.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			photo=new Photo();
			photo.setPhotoId(resultSet.getInt(1));
			photo.setPhotoAddress(resultSet.getString(2));
			photo.setPhotoTime(resultSet.getString(3));
			photo.setpTypeId(resultSet.getInt(4));
			photo.setUserId(resultSet.getInt(5));
			photo.setArticleId(resultSet.getInt(6));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		JDBCUtils.release(connection, preparedStatement, resultSet);
	}
	return photo;
}
public List selectPhoto4(int articleId){
	List list=new ArrayList();
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	Photo photo=null;
	try {
		connection=JDBCUtils.getConnection();
		String sql="select * from photo where articleId='"+articleId+"'";
		preparedStatement=connection.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			photo=new Photo();
			photo.setPhotoId(resultSet.getInt(1));
			photo.setPhotoAddress(resultSet.getString(2));
			photo.setPhotoTime(resultSet.getString(3));
			photo.setpTypeId(resultSet.getInt(4));
			photo.setUserId(resultSet.getInt(5));
			photo.setArticleId(resultSet.getInt(6));
			list.add(photo);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		JDBCUtils.release(connection, preparedStatement, resultSet);
	}
	return list;
}
public Photo selectPhoto3(){
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	Photo photo=null;
	try {
		connection=JDBCUtils.getConnection();
		String sql="SELECT * from photo where photoId = (SELECT max(photoId) FROM photo)";
		preparedStatement=connection.prepareStatement(sql);
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
			photo=new Photo();
			photo.setPhotoId(resultSet.getInt(1));
			photo.setPhotoAddress(resultSet.getString(2));
			photo.setPhotoTime(resultSet.getString(3));
			photo.setpTypeId(resultSet.getInt(4));
			photo.setUserId(resultSet.getInt(5));
			photo.setArticleId(resultSet.getInt(6));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		JDBCUtils.release(connection, preparedStatement, resultSet);
	}
	return photo;
}
}

