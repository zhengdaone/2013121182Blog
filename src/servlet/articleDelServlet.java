package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.articleDao;

public class articleDelServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		int articleId=Integer.parseInt(request.getParameter("pid"));
		articleDao aDao=new articleDao();
		aDao.deleteArticle(articleId);
		int typeId=Integer.parseInt(request.getParameter("pidd"));
		request.setAttribute("typeId2", typeId);
		request.getRequestDispatcher("allBlog1.jsp").forward(request, response);
		
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
