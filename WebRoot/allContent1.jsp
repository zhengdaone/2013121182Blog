<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import ="java.util.*" %>
<%@ page import ="Dao.*" %>
<%@ page import ="DataBean.*" %>
<jsp:useBean id="articleDao" class="Dao.articleDao" scope="request"></jsp:useBean>
<jsp:useBean id="commentDao" scope="page" class="Dao.commentDao"></jsp:useBean>
<%
String username=(String)session.getAttribute("username");
if(username==null){
response.sendRedirect("Login.jsp");
}

 %>
<%
int articleId = Integer.parseInt(request.getParameter("articleId"));
Article article=articleDao.queryArticle(articleId);
List list=commentDao.selectComment(articleId);
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
  <h1 class="t_nav"><span>记忆着曾经那些点点滴滴的往事！</span><a href="allBlog2.jsp" class="n1">所有博客</a><a  class="n2"><%=article.getTitle()%></a></h1>
  <div class="bloglist">
    <ul class="arrow_box">
         <div class="sy">
      <p> <%=article.getContent() %></p>
        </div>
      <span class="dateview"><%=article.getPublishTime() %></span>  
  </div>
</div>
<dl>
	  <%
for(int i=0;i<list.size();i++){
Comment comment=(Comment)list.get(i);
 %>
	   <table width="345"  border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#000000">
        <tr>
          <td bgcolor="#FFFFFF">评论内容：<%=comment.getComContent()%></td>
          <td bgcolor="#FFFFFF"><div align="right">评论人：<%=comment.getfName() %></div></td>
        </tr>
      </table>
	  <%} %>
	   <form name="form" method="post" action="comment">
	  <table width="261"  border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#000000">
        <tr>
          <td height="139" bgcolor="#FFFFFF">评论内容：</td>
          <td bgcolor="#FFFFFF"><textarea name="comContent" rows="10" class="inputinput"><%if(request.getAttribute("result")!=null){out.print(request.getAttribute("result"));} %></textarea></td>
        </tr>
       <tr>
          <td bgcolor="#FFFFFF"><input name="articleId" type="hidden" class="inputinput"  size="40" value="<%=articleId%>">评&nbsp;论&nbsp;人：</td>
          <td bgcolor="#FFFFFF"><input name="fName" type="hidden" class="inputinput" size="26" value="<%=username%>"><%=username%></td>
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