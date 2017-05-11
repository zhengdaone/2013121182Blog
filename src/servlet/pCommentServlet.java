package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Dao.pCommentDao;
import DataBean.pComment;

public class pCommentServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String result=null;
		String comContent =request.getParameter("comContent");
		String fName=request.getParameter("fName");
		int photoId =Integer.parseInt(request.getParameter("photoId"));
		if(comContent.trim().length()==0){
			result="输入不能为空";
			request.setAttribute("result", result);
			request.setAttribute("photoId", photoId);
			request.getRequestDispatcher("fullPhoto1.jsp").forward(request, response);
		}else{
		pComment comment =new pComment();
		if(fName.equals("游客")){
			comment.setComContent(comContent);
			comment.setPhotoId(photoId);
			comment.setfName(fName);
			pCommentDao cDao=new pCommentDao();
			cDao.insertpComment(comment);
			request.setAttribute("photoId", photoId);
			request.getRequestDispatcher("fullPhoto1.jsp").forward(request, response);
		}else{
		comment.setComContent(comContent);
		comment.setPhotoId(photoId);
		comment.setfName(fName);
		pCommentDao cDao=new pCommentDao();
		cDao.insertpComment(comment);
		request.setAttribute("photoId", photoId);
		request.getRequestDispatcher("fullPhoto1.jsp").forward(request, response);
		}
	}
	}
}
