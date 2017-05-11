<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import ="java.util.*" %>
<%@ page import ="Dao.*" %>
<%@ page import ="DataBean.*" %>
<jsp:useBean id="pType" class="Dao.photoTypeDao"></jsp:useBean>
<jsp:useBean id="photoDao" class="Dao.photoDao"></jsp:useBean>
<jsp:useBean id="pCommentDao" class="Dao.pCommentDao"></jsp:useBean>
<%@ page import="DataBean.*" %>

<%
String username=(String)session.getAttribute("username");
if(username==null){
response.sendRedirect("Login.jsp");
}
 %>
<%
List list=pType.selectPType();
int photoId=Integer.parseInt(request.getParameter("photoId"));
Photo photo=photoDao.selectPhoto1(photoId);
List pclist=pCommentDao.selectpComment(photoId);
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
  <h1 class="t_nav"><span>记忆着曾经那些点点滴滴的往事！</span></h1>

  <table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>	 
   <td valign="top" align="right">
<input type="button" onclick="location='javascript:history.go(-1);'"  value="返回">
	<%
out.println("<br><p align=left>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;相片详情</p>");%>
</td>

    <table width="800" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF"  bgcolor="#FEce62">
      <tr bgcolor="#FFFFFF">
        <td width="166"><div align="center">
            <table width="341" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="150"><div align="center"><a ><img src="<%=photo.getPhotoAddress()%>" width="800" height="600"></a></div></td>
              </tr>
            </table>
        </div></td>
        </table>
        </table>      
<footer>
  <p><span>网站地图</span><span><a href="/">网站统计</a></span></p>
</footer>
<script src="js/nav.js"></script>
</body>
</html>