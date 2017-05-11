<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import ="java.util.*" %>
<%@ page import ="Dao.*" %>
<%@ page import ="DataBean.*" %>
<jsp:useBean id="pType" class="Dao.photoTypeDao"></jsp:useBean>
<jsp:useBean id="photoDao" class="Dao.photoDao"></jsp:useBean>
<jsp:useBean id="pCommentDao" class="Dao.pCommentDao"></jsp:useBean>
<jsp:useBean id="pReplyDao" class="Dao.pReplyDao"></jsp:useBean>
<%@ page import="DataBean.*" %>

<%
String username=(String)session.getAttribute("username");
if(username==null){
response.sendRedirect("Login.jsp");
}
 %>
<%
Integer photoId=Integer.parseInt(request.getParameter("photoId"));
Photo photo=photoDao.selectPhoto1(photoId);
Integer pCommentId=Integer.parseInt(request.getParameter("pCommentId"));
List list=pReplyDao.selectpReply(pCommentId);
pComment pcomment=pCommentDao.selectComment2(pCommentId);
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
 <script type="text/javascript">
function chk(id,idd)
  {
    
   if(confirm("你确定要删除吗？"))
       {
          location.href="photoDel?pid="+id+"&pidd="+idd;
       }
  } 
</script>
<div class="moodlist">
  <h1 class="t_nav"><span>记忆着曾经那些点点滴滴的往事！</span></h1>
  <table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>	
     <td  align="right">
<input type="button" onclick="chk('<%=photo.getPhotoId()%>','<%=photo.getPhotoAddress() %>')"  value="删除相片">
	<input type="button" onclick="location='javascript:history.go(-1);'"  value="返回">
	<%
out.println("<br><p align=left>&nbsp;&nbsp;&nbsp;&nbsp;相片详情</p>");
%>

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
 <table width="345"  border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#000000">
        <tr>
          <td bgcolor="#FFFFFF">评论内容：<%=pcomment.getComContent()%></td>
          <td bgcolor="#FFFFFF"><div align="right">评论人：<%=pcomment.getfName() %></div></td>
        </tr>
      </table>
	   <%
        for(int i=0;i<list.size();i++){
        pReply reply=(pReply)list.get(i);       
         %>
      <table width="345"  border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#000000">
        <tr>
          <td bgcolor="#FFFFFF">回复内容：<%=reply.getReContent()%></td>
          <td bgcolor="#FFFFFF"><div align="right">回复人：<%=reply.getReUser() %></div></td>
        </tr>
      </table>
      <%} %>
      <form name="form" method="post" action="pReply">
	  <table width="261"  border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#000000">
        <tr>
          <td height="139" bgcolor="#FFFFFF">回复内容：</td>
          <td bgcolor="#FFFFFF"><textarea name="reContent" rows="10" class="inputinput"></textarea></td>
        </tr>
       <tr>
          <td bgcolor="#FFFFFF"><input name="commentId" type="hidden" class="inputinput"  size="40" value="<%=pcomment.getpCommentId()%>"><input name="photoId" type="hidden" class="inputinput"  size="40" value="<%=photoId%>">回&nbsp;复&nbsp;人：</td>
          <td bgcolor="#FFFFFF"><input name="reUser" type="hidden" class="inputinput" size="26" value="<%=username%>"><%=username%></td>
        </tr>
      </table>
	   <table width="284"  border="0" align="center">
         <tr>
           <td>
             <div align="center">
 <input type="image" class="inputinputinput" src="images/save.gif">
&nbsp;&nbsp;
         </tr>
       </table>
	   </form>
<footer>
  <p><span>网站地图</span><span><a href="/">网站统计</a></span></p>
</footer>
<script src="js/nav.js"></script>
</body>
</html>