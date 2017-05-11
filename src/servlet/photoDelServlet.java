package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.photoDao;

import com.jspsmart.upload.File;

public class photoDelServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int photoId=Integer.parseInt(request.getParameter("pid"));
		photoDao photoDao = new photoDao();
		String photoDir = this.getServletContext().getRealPath(photoDao.selectPhoto1(photoId).getPhotoAddress());
		java.io.File file = new java.io.File(photoDir);
		if(file.exists()){
		file.delete();
		}
		photoDao pDao=new photoDao();
		pDao.deletePhoto(photoId);
		response.sendRedirect("photo.jsp");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
