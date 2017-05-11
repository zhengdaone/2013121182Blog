package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tool.JDBCUtils;

import Dao.articleDao;
import Dao.friendDao;
import DataBean.Article;
import DataBean.Friend;

public class friendAddServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String result=null;
		int userId=(Integer)request.getSession().getAttribute("userId"); 
		String fName=request.getParameter("fName");
		int friendId =Integer.parseInt(request.getParameter("friendId"));
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
				try {
					conn=JDBCUtils.getConnection();
						String sql="select username,userId from consumer where username='"+fName+"'";
						pstmt=conn.prepareStatement(sql);
						rs=pstmt.executeQuery();		
					if(rs.next()){
						if(rs.getString(1).equals(null)||rs.getInt(2)!=friendId){
							result="添加失败，用户不存在";
							request.setAttribute("result", result);
							request.getRequestDispatcher("friendManage.jsp").forward(request, response);
						}else {
							Friend friend=new Friend();
							friend.setfName(fName);		
							friend.setUserId(userId);
							friend.setFriendId(friendId);
							friendDao fDao=new friendDao();
							fDao.inserfriend(friend);
							result="添加成功";
							request.setAttribute("result", result);
							request.getRequestDispatcher("friendManage.jsp").forward(request, response);
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
}
}
		


