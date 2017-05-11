package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Tool.JDBCUtils;

import DataBean.photoType;

public class photoTypeDao {
	public List selectPType(){
		List list=new ArrayList();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		photoType pType=null;
		try {
			connection=JDBCUtils.getConnection();
			String sql="select pTypeId,pTypeName from photoType";
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				pType=new photoType();
				pType.setpTypeId(resultSet.getInt(1));
				pType.setpTypeName(resultSet.getString(2));
				list.add(pType);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(connection, preparedStatement, resultSet);
		}
		return list;
	}
}
