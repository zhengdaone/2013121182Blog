<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import ="java.util.*" %>
<%@ page import ="Dao.*" %>
<%@ page import ="DataBean.*" %>
<jsp:useBean id="pType" class="Dao.photoTypeDao"></jsp:useBean>
<jsp:useBean id="photoDao" class="Dao.photoDao"></jsp:useBean>
<jsp:useBean id="pagination" class="Tool.Pagination" scope="session"></jsp:useBean>
<%@ page import="DataBean.*" %>
<%
String username=(String)session.getAttribute("username");
if(username==null){
response.sendRedirect("Login.jsp");
}else{
List list=pType.selectPType();
int userId=Integer.parseInt(request.getParameter("friendId"));
String str=(String)request.getParameter("Page");
int Page=1;
List photoList=null;
if(str==null){
	photoList=photoDao.selectPhoto(userId);
	int pagesize=5;      //指定每页显示的记录数
	photoList=pagination.getInitPage(photoList,Page,pagesize);     //初始化分页信息
}else{
	Page=pagination.getPage(str);
	photoList=pagination.getAppointPage(Page);     //获取指定页的数据
}
 %> 
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>博客全文</title>
<meta name="keywords" content="个人博客" />
<meta name="description" content="" />
<link href="css/index.css" rel="stylesheet">
<link href="css/ty.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
</head>
<body>
<%@ include file="header.jsp" %>
<div class="moodlist">
  <h1 class="t_nav"><span>记忆着曾经那些点点滴滴的往事！</span><a href="/2013121182Blog/fArticle1.jsp?friendId=<%=userId%>" class="n1">好友文章</a><a href="/2013121182Blog/fphoto.jsp?friendId=<%=userId%>" class="n1">相册</a></h1>
  <form name="form" method="post" action="photoManage">
<div align="center">
  <table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>	
	<%
out.println("<br><p align=left>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;查询所有的相片</p>");
%>
<%
for(int i=0;i<photoList.size();i++){
Photo photo=(Photo)photoList.get(i);
 %>
    <table width="341" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF"  bgcolor="#FEce62">
      <tr bgcolor="#FFFFFF">
        <td width="166"><div align="center">
            <table width="341" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="150"><div align="center"><a href="#" onClick="location='fullPhoto.jsp?photoId=<%=photo.getPhotoId()%>'"><img src="<%=photo.getPhotoAddress()%>" width="160" height="140"></a></div></td>
              </tr>
                <tr>
                <td height="15"><div align="center">点击图片查看更多</a></div></td>
              </tr>
            </table>
        </div></td>
        <%} %>
        </table>
        </table>
        <%=pagination.printCtrl2(Page, userId) %> 
<footer>
  <p><span>网站地图</span><span><a href="/">网站统计</a></span></p>
</footer>
<script src="js/nav.js"></script>
</body>
</html>
<%}%>