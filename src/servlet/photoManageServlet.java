package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class photoManageServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int  pTypeId=Integer.parseInt(request.getParameter("typeId"));
		request.setAttribute("pTypeId", pTypeId);
		request.getRequestDispatcher("photo1.jsp").forward(request, response);
	}

}
