package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.commentDao;
import Dao.consumerDao;
import DataBean.Comment;

public class commentServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String result=null;
		String comContent =request.getParameter("comContent");
		String fName=request.getParameter("fName");
		int articleId =Integer.parseInt(request.getParameter("articleId"));
		Comment comment =new Comment();
		if(fName.equals("сн©м")){
			comment.setComContent(comContent);
			comment.setArticleId(articleId);
			comment.setfName(fName);
			commentDao cDao=new commentDao();
			cDao.insertComment(comment);
			request.setAttribute("articleId", articleId);
			request.getRequestDispatcher("allContent1.jsp").forward(request, response);
		}else{
		comment.setComContent(comContent);
		comment.setArticleId(articleId);
		comment.setfName(fName);
		commentDao cDao=new commentDao();
		cDao.insertComment(comment);
		request.setAttribute("articleId", articleId);
		request.getRequestDispatcher("fallContent1.jsp").forward(request, response);
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
