<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="java.util.*" %>
<%@ page import ="Dao.*" %>
<%@ page import ="DataBean.*" %>
<jsp:useBean id="articleDao" class="Dao.articleDao" scope="request"></jsp:useBean>
<jsp:useBean id="articleTypeDao" scope="page" class="Dao.articleTypeDao"></jsp:useBean>
<jsp:useBean id="pagination" class="Tool.Pagination" scope="session"></jsp:useBean>
<%
String username=(String)session.getAttribute("username");
if(username==null||username.equals("游客")){
String result="无权限访问，请登录或注册";
request.setAttribute("result", result);
request.getRequestDispatcher("register.jsp").forward(request, response);
}

 %>
<%
List list=articleTypeDao.queryArticleType();
%>
<%
Integer userId=(Integer)session.getAttribute("userId");
String str=(String)request.getParameter("Page");
int Page=1;
List articleList=null;
if(str==null){
	articleList=articleDao.selectArticle3(userId);
	request.setAttribute("articleList", articleList);
	int pagesize=5;      //指定每页显示的记录数
	articleList=pagination.getInitPage(articleList,Page,pagesize);     //初始化分页信息
}else{
	Page=pagination.getPage(str);
	articleList=pagination.getAppointPage(Page);     //获取指定页的数据
	request.setAttribute("articleList", articleList);
}
 %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>所有博客</title>
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
  <h1 class="t_nav"><span>记忆着曾经那些点点滴滴的往事！</span><a  class="n1">所有博客</a><a href="/2013121182Blog/addArticle.jsp" class="n1">添加文章</a></h1>
  <form name="form" method="post" action="articleManage">
<div align="center">
													文章类别：
												</div>
											</td>
											<td bgcolor="#FFFFFF">
												<div align="center">
								<select name="typeId" class="inputinput">
							<%
								for(int i=0;i<list.size();i++){ 
								articleType form=(articleType)list.get(i);
								%>
									<option value="<%=form.getTypeId()%>"><%=form.getTypeName() %></option>
								<%} %>
													</select>
																									<div class="form_row">
                    <input type="submit" class="register" value="确定" />
                    </div> 
												</div>

												</form>
<c:forEach items="${articleList}" var="item" >
 <h1 class="t_nav"><a href="allContent.jsp?articleId=<c:out value="${item.articleId }"></c:out>" class="n2"><c:out value="${item.title }"></c:out></a></h1>
  <div class="bloglist">
    <ul class="arrow_box">
         <div class="sy">
      <p> <c:out value="${item.content }"></c:out></p>
        </div>
      <span class="dateview"><c:out value="${item.publishTime }"></c:out></span>
          </ul>
          </div>
</c:forEach>
<%=pagination.printCtrl(Page) %> 
<footer>
  <p><span>网站地图</span><span><a href="/">网站统计</a></span></p>
</footer>
<script src="js/nav.js"></script>
</body>
</html>