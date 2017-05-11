package Dao;

import java.sql.*;
import java.util.*;

import javax.servlet.jsp.*;

import javax.jms.Session;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import DataBean.articleType;


import DataBean.articleType;
import Tool.JDBCUtils;



public class articleTypeDao {
	public List queryArticleType() {
		List list = new ArrayList();
		articleType form = null;
		Connection con = null ; 
		PreparedStatement ps = null ;    
		ResultSet rs = null;  
		try {
			con = JDBCUtils.getConnection();
			String sql = "select typeId,typeName from articletype";
			ps=con.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					form = new articleType();
					form.setTypeId(rs.getInt(1));
					form.setTypeName(rs.getString(2));
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
}
