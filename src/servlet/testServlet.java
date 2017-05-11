package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Pagination;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.articleDao;
import DataBean.Article;
import Tool.*;

public class testServlet extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List list=new ArrayList();
		Article article=null;
		int pagenow=1;
		String pagenow1=request.getParameter("pagenow");
		if(pagenow1!=null){		
			pagenow=Integer.parseInt(pagenow1);
		}
		int pagesize=2;
		int pagenum;
		int renum;
		String page=null;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		articleDao aDao=new articleDao();
		list=aDao.selectArticle();
			renum=Pagination2.Renum(list);
			pagenum=Pagination2.Pagenum(pagesize, renum);
			page=Pagination2.Page(pagenow,pagenum);
			list=Pagination2.dateList(pagenow,list,pagesize);
			request.setAttribute("page", page);
			request.setAttribute("list", list);
			request.getRequestDispatcher("test.jsp").forward(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
