package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.articleDao;

public class searchServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String result=null;
		String username=(String)request.getSession().getAttribute("username");
		if(username.equals("�ο�")){
			result="δ��¼�û���Ȩʹ�ô˹��ܣ����¼��ע��";
			request.setAttribute("result", result);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}else{
		String searchstr=request.getParameter("searchstr");
		int userId=(Integer)request.getSession().getAttribute("userId");
		articleDao aDao=new articleDao();
		List articleList=aDao.selectArticle5(searchstr, userId);
		if(articleList.size()<=0){
			result="δ�ܲ�ѯ���������";
		}
		request.setAttribute("result", result);
		request.setAttribute("searchstr", searchstr);
		request.getRequestDispatcher("allBlog3.jsp").forward(request, response);
	}
	}

}
