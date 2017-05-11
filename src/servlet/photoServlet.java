package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.photoDao;
import DataBean.Photo;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;


public class photoServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		photoDao pDao= new photoDao();
		Photo photo=new Photo();
		com.jspsmart.upload.SmartUpload su = new com.jspsmart.upload.SmartUpload();
		Integer maxID = 0;
		if (pDao.MaxQueryID() != null) {
			maxID = pDao.MaxQueryID();
		}
		String result = "上传的照片格式和大小有问题,上传照片失败!";
		String type = null;
		String imageType[] = { "jpg", "gif"};
		String filedir = "images/";
		long maxsize = 2 * 1024 * 1024; 
		try {
			su.initialize(this.getServletConfig(), request, response);
			su.setMaxFileSize(maxsize); 
			su.upload(); 
			Files files = su.getFiles(); 
			for (int i = 0; i < files.getCount(); i++) { 
				File singlefile = files.getFile(i);
				type = singlefile.getFileExt();

				for (int ii = 0; ii < imageType.length; ii++) {
					if (imageType[ii].equals(type)) {
						if (!singlefile.isMissing()) { 
							Date date = new Date();
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:mm"); 
							String photoTime =format.format(date);
							int userId=(Integer)request.getSession().getAttribute("userId");
							int pTypeId=Integer.parseInt(su.getRequest().getParameter("typeId"));
							photo.setpTypeId(pTypeId);
							photo.setUserId(userId);
							photo.setPhotoTime(photoTime);
							filedir = filedir + maxID + "."
									+ singlefile.getFileExt();
							photo.setPhotoAddress(filedir);
							pDao.insertPhoto(photo);							
							singlefile.saveAs(filedir, File.SAVEAS_VIRTUAL);
								result = "上传照片成功!";
							
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("result", result);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("insertPhoto.jsp");
		requestDispatcher.forward(request, response);
	}
	}


