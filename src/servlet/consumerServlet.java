package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;
import java.text.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tool.JDBCUtils;

import Dao.consumerDao;
import DataBean.Consumer;

public class consumerServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		request.setCharacterEncoding("utf-8");
		String username=null;
		String password=null;
		username=request.getParameter("username");
		password=request.getParameter("password");
		String pwdConfirm=request.getParameter("pwdConfirm");
		String sex=request.getParameter("sex");
		String email=request.getParameter("email");					
								Connection conn=null;
								PreparedStatement pstmt=null;
								ResultSet rs=null;
								if(username.trim().length()==0||password.trim().length()==0||pwdConfirm.trim().length()==0||email.trim().length()==0){
									request.setAttribute("result", "请填写所有资料");
									request.getRequestDispatcher("register.jsp").forward(request, response);
								}else {
										try {
											conn=JDBCUtils.getConnection();
											String sql="select username from consumer where username='"+username+"'";
											pstmt=conn.prepareStatement(sql);
											rs=pstmt.executeQuery();										
											if(rs.next()){
												if(!rs.getString(1).equals(null))
													request.setAttribute("result", "用户已存在");
													request.getRequestDispatcher("register.jsp").forward(request, response);											
											}else {
													if(password.equals(pwdConfirm)){
														Date date = new Date();
														SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:mm"); 
														String registerTime =format.format(date);
														Consumer cons=new Consumer();
														cons.setUsername(username);
														cons.setPassword(password);
														cons.setSex(sex);
														cons.setEmail(email);
														cons.setRegisterTime(registerTime);
														System.out.println(registerTime);
														consumerDao cDao=new consumerDao();
														cDao.inserConsumer(cons);
														response.sendRedirect("Login.jsp");
													}else {
														request.setAttribute("result", "两次输入密码不同");
														request.getRequestDispatcher("register.jsp").forward(request, response);
													}
												}
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}finally{
											JDBCUtils.release(conn, pstmt, rs);
										}
								}
							}
						
	
}
