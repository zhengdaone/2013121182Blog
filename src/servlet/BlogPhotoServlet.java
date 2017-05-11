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
		String result = "�ϴ�����Ƭ��ʽ�ʹ�С������,�ϴ���Ƭʧ��!";
		String type = null;
		String imageType[] = { "jpg", "gif"};
		String filedir = "images/";
		long maxsize = 2 * 1024 * 1024; // ����ÿ���ϴ��ļ��Ĵ�С��Ϊ2MB
		try {
			su.initialize(this.getServletConfig(), request, response);
			su.setMaxFileSize(maxsize); // �����ϴ��ļ��Ĵ�С
			su.upload(); // �ϴ��ļ�
			Files files = su.getFiles(); // ��ȡ���е��ϴ��ļ�
			for (int i = 0; i < files.getCount(); i++) { // �����ȡ�ϴ����ļ�
				File singlefile = files.getFile(i);
				type = singlefile.getFileExt();

				for (int ii = 0; ii < imageType.length; ii++) {
					if (imageType[ii].equals(type)) {
						if (!singlefile.isMissing()) { // ���ѡ�����ļ�
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
								result = "�ϴ���Ƭ�ɹ�!";
							
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
