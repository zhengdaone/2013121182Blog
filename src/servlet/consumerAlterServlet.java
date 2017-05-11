package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.consumerDao;
import DataBean.Consumer;

public class consumerAlterServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		int userId=Integer.parseInt(request.getParameter("userId"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String pwdConfirm=request.getParameter("pwdConfirm");
		String sex=request.getParameter("sex");
		String email=request.getParameter("email");
		if(password.equals(pwdConfirm)){
		Consumer cons=new Consumer();
		cons.setUserId(userId);
		cons.setUsername(username);
		cons.setPassword(password);
		cons.setSex(sex);
		cons.setEmail(email);
		consumerDao cDao=new consumerDao();
		cDao.updateConsumer(cons);
		response.sendRedirect("Login.jsp");
	}else{
		response.sendRedirect("consumerAlter.jsp");
	}

}
}
