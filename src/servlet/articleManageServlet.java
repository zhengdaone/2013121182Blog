package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.articleDao;

public class articleManageServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String result=null;
		int typeId=Integer.parseInt(request.getParameter("typeId"));
		int userId=(Integer)(request.getSession().getAttribute("userId"));
		articleDao articleDao=new articleDao();
		List articleList=articleDao.queryArticleType(typeId,userId);
		if(articleList.size()<=0){
			result="该分类无文章";
		}
		request.setAttribute("result", result);
		request.setAttribute("typeId2", typeId);
		request.getRequestDispatcher("allBlog1.jsp").forward(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
}
