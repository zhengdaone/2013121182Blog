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

public class BlogPhotoServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		photoDao pDao= new photoDao();
		Photo photo=new Photo();
		int articleId=0;
		com.jspsmart.upload.SmartUpload su = new com.jspsmart.upload.SmartUpload();
		Integer maxID = 0;
		if (pDao.MaxQueryID() != null) {
			maxID = pDao.MaxQueryID();
		}
		String result = "上传的照片格式和大小有问题,上传照片失败!";
		String type = null;
		String imageType[] = { "jpg", "gif"};
		String filedir = "images/";
		long maxsize = 2 * 1024 * 1024; // 设置每个上传文件的大小，为2MB
		try {
			su.initialize(this.getServletConfig(), request, response);
			su.setMaxFileSize(maxsize); // 限制上传文件的大小
			su.upload(); // 上传文件
			Files files = su.getFiles(); // 获取所有的上传文件
			for (int i = 0; i < files.getCount(); i++) { // 逐个获取上传的文件
				File singlefile = files.getFile(i);
				type = singlefile.getFileExt();

				for (int ii = 0; ii < imageType.length; ii++) {
					if (imageType[ii].equals(type)) {
						if (!singlefile.isMissing()) { // 如果选择了文件
							Date date = new Date();
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:mm"); 
							String photoTime =format.format(date);
							int userId=(Integer)request.getSession().getAttribute("userId");
							int pTypeId=Integer.parseInt(su.getRequest().getParameter("typeId"));
							articleId=Integer.parseInt(su.getRequest().getParameter("articleId"));
							photo.setpTypeId(pTypeId);
							photo.setUserId(userId);
							photo.setArticleId(articleId);
							photo.setPhotoTime(photoTime);
							filedir = filedir + maxID + "."
									+ singlefile.getFileExt();
							photo.setPhotoAddress(filedir);
							pDao.insertPhoto1(photo);							
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
		request.setAttribute("articleId", articleId);
		request.getRequestDispatcher("insertBPhoto1.jsp").forward(request, response);
	}

}
