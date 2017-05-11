package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tool.JDBCUtils;

import Dao.consumerDao;
import DataBean.Consumer;

public class consumerLoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.equals("сн©м")){
			HttpSession session=request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password", 0);
			session.setAttribute("userId", 1);
			response.sendRedirect("allBlog2.jsp");
		}else{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
				String sql="select username,password,userId from consumer where username='"+username+"'";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();		
			if(rs.next()){
				if(rs.getString(1).equals(username )){
					if(rs.getString(2).equals(password)){
						HttpSession session=request.getSession();
						session.setAttribute("username", username);
						session.setAttribute("password", password);
						session.setAttribute("userId", rs.getInt(3));
						response.sendRedirect("index.jsp");
					}
					else{
						response.sendRedirect("Login.jsp");
						}
				}else{
				response.sendRedirect("Login.jsp");
				}
				}else{
				response.sendRedirect("Login.jsp");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.release(conn, pstmt, rs);
		}
}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doPost(request, response);
	}
}
