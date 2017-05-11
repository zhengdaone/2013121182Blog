package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.articleDao;
import DataBean.Article;

public class articleServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		Integer userId=(Integer)request.getSession().getAttribute("userId");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd H:mm");
		String publishTime=format.format(date);
		Article article=new Article();
		article.setTypeId(typeId);
		article.setTitle(title);
		article.setContent(content);
		article.setPublishTime(publishTime);
		article.setUserId(userId);
		System.out.println(userId);
		articleDao artD=new articleDao();
		artD.insertArticle(article);
		request.setAttribute("typeId2",typeId );
		request.getRequestDispatcher("allBlog1.jsp").forward(request, response);
		}
}
