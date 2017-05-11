package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.pReplyDao;
import Dao.replyDao;
import DataBean.Reply;
import DataBean.pReply;

public class pReplyServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String result=null;
		int pCommentId=Integer.parseInt(request.getParameter("commentId"));
		int photoId=Integer.parseInt(request.getParameter("photoId"));
		String reContent=request.getParameter("reContent");
		String reUser=request.getParameter("reUser");
		if(reContent.trim().length()==0){
			result="输入不能为空";
			request.setAttribute("result", result);
			request.setAttribute("pCommentId", pCommentId);
			request.setAttribute("photoId", photoId);
			request.getRequestDispatcher("preply1.jsp").forward(request, response);
		}else{
		pReply reply=new pReply();
		reply.setpCommentId(pCommentId);
		reply.setReContent(reContent);
		reply.setReUser(reUser);
		pReplyDao replyDao=new pReplyDao();
		replyDao.insertpReply(reply);
		request.setAttribute("pCommentId", pCommentId);
		request.setAttribute("photoId", photoId);
		request.getRequestDispatcher("preply1.jsp").forward(request, response);
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	

}
