package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.replyDao;
import DataBean.Comment;
import DataBean.Reply;

public class replyServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String result=null;
		int commentId=Integer.parseInt(request.getParameter("commentId"));
		int articleId=Integer.parseInt(request.getParameter("articleId"));
		String reContent=request.getParameter("reContent");
		String reUser=request.getParameter("reUser");
		if(reContent.trim().length()==0){
			result="输入不能为空";
			request.setAttribute("result", result);
			request.setAttribute("commentId", commentId);
			request.setAttribute("article", articleId);
			request.getRequestDispatcher("reply.jsp").forward(request, response);
		}else{
		Reply reply=new Reply();
		reply.setCommentId(commentId);
		reply.setReContent(reContent);
		reply.setReUser(reUser);
		replyDao replyDao=new replyDao();
		replyDao.insertReply(reply);
		request.setAttribute("commentId", commentId);
		request.setAttribute("article", articleId);
		request.getRequestDispatcher("reply.jsp").forward(request, response);
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
