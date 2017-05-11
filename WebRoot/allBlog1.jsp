<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import ="java.util.*" %>
<%@ page import ="Dao.*" %>
<%@ page import ="DataBean.*" %>
<jsp:useBean id="articleDao" class="Dao.articleDao" scope="request"></jsp:useBean>
<jsp:useBean id="articleTypeDao" scope="page" class="Dao.articleTypeDao"></jsp:useBean>
<jsp:useBean id="pagination" class="Tool.Pagination" scope="session"></jsp:useBean>
<%
String username=(String)session.getAttribute("username");
if(username==null){
response.sendRedirect("Login.jsp");
}
 %>
<%
List list=articleTypeDao.queryArticleType();
%>
<%
Integer userId=(Integer)session.getAttribute("userId");
Integer typeId=(Integer)request.getAttribute("typeId2");
String str=(String)request.getParameter("Page");
int Page=1;
List articleList=null;
if(str==null){
	articleList=articleDao.queryArticleType(typeId,userId);
	int pagesize=5;      //指定每页显示的记录数
	articleList=pagination.getInitPage(articleList,Page,pagesize);     //初始化分页信息
}else{
	Page=pagination.getPage(str);
	articleList=pagination.getAppointPage(Page);     //获取指定页的数据
}
String type=null;
if(typeId==1){
type="情感";
}else if(typeId==2){
type="搞笑";
}else if(typeId==3){
type="日记";
}else if(typeId==4){
type="娱乐";
}else if(typeId==5){
type="旅游";
}else{
type="其它";
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
 <script type="text/javascript">
function chk(id,idd)
  {
    
   if(confirm("你确定要删除吗？"))
       {
          location.href="articleDel?pid="+id+"&pidd="+idd;
       }
  } 
 function update(id)
 {
          location.href="updateArticle.jsp?id="+id;
 }
  function qq()
 {
          alert("haha");
 }
</script>
<div class="moodlist">
  <h1 class="t_nav"><span>记忆着曾经那些点点滴滴的往事！</span><a class="n1"><%=type %></a><a href="/2013121182Blog/addArticle.jsp" class="n1">添加文章</a></h1>
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
<%for(int i=0;i<articleList.size();i++){
Article article =new Article();
article=(Article)articleList.get(i);
%>
 <h1 class="t_nav"><a href="/2013121182Blog/allContent.jsp?articleId=<%=article.getArticleId()%>" class="n2"><%=article.getTitle() %></a></h1> 

  <div class="bloglist">
    <ul class="arrow_box">
         <div class="sy">
      <p> <%=article.getContent() %></p>
      
        </div>  
            
      <span class="dateview"><%=article.getPublishTime() %></span>  
         
  </div>
  
  <input type="button" onclick="chk('<%=article.getArticleId() %>','<%=typeId%>')"  value="删除">
     <input type="button" onclick="update('<%=article.getArticleId() %>')"  value="修改">
     <input type="button" onclick="qq()"  value="haha">
</div>
<%} %>
<%=pagination.printCtrl(Page) %> 
<div align="center">
<%if(request.getAttribute("result")!=null){
			out.print(request.getAttribute("result"));
			} %>
			</div>
<footer>

  <p><span>网站地图</span><span><a href="/">网站统计</a></span></p>
</footer>
<script src="js/nav.js"></script>
</body>
</html>