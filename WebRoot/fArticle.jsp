<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import ="java.util.*" %>
<%@ page import ="Dao.*" %>
<%@ page import ="DataBean.*" %>
<jsp:useBean id="articleDao" class="Dao.articleDao" scope="request"></jsp:useBean>
<jsp:useBean id="pagination" class="Tool.Pagination" scope="session"></jsp:useBean>
<%
String username=(String)session.getAttribute("username");
if(username==null){
response.sendRedirect("Login.jsp");
}

 %>
<%
int friendId=(Integer)request.getAttribute("friendId");
String str=(String)request.getParameter("Page");
int Page=1;
List articleList=null;
if(str==null){
	articleList=articleDao.selectArticle2(friendId);
	int pagesize=5;      //指定每页显示的记录数
	articleList=pagination.getInitPage(articleList,Page,pagesize);     //初始化分页信息
}else{
	Page=pagination.getPage(str);
	articleList=pagination.getAppointPage(Page);     //获取指定页的数据
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
  <h1 class="t_nav"><span>记忆着曾经那些点点滴滴的往事！</span><a href="/2013121182Blog/fArticle1.jsp?friendId=<%=friendId%>" class="n1">好友文章</a><a href="/2013121182Blog/fphoto.jsp?friendId=<%=friendId%>" class="n1">相册</a></h1>
<%for(int i=0;i<articleList.size();i++){
Article article =new Article();
article=(Article)articleList.get(i);
%>
 <h1 class="t_nav"><a href="fallContent.jsp?articleId=<%=article.getArticleId() %>"  class="n2"><%=article.getTitle() %></a></h1> 

  <div class="bloglist">
    <ul class="arrow_box">
         <div class="sy">
      <p> <%=article.getContent() %></p>
      
        </div>      
      <span class="dateview"><%=article.getPublishTime() %></span>     
  </div>
</div>
<%} %>
<%=pagination.printCtrl2(Page, friendId) %> 
<footer>
  <p><span>网站地图</span><span><a href="/">网站统计</a></span></p>
</footer>
<script src="js/nav.js"></script>
</body>
</html>