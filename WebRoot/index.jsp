<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="Dao.*"%>
<%@ page import="DataBean.Friend" %>
<%@ page import="DataBean.Article" %>
<%@page import="DataBean.articleType"%>
<%@ page import="java.util.*" %>
<jsp:useBean id="articleDao" scope="page" class="Dao.articleDao"></jsp:useBean>
<jsp:useBean id="friendDao" scope="session" class="Dao.friendDao"></jsp:useBean>
<%
String username=(String)session.getAttribute("username");
if(username==null||username.equals("游客")){
String result="无权限访问，请登录或注册";
request.setAttribute("result", result);
request.getRequestDispatcher("register.jsp").forward(request, response);
}
 %>
<%
Integer userId=(Integer)session.getAttribute("userId");
List list=friendDao.queryFriend(userId);
List articleList=articleDao.selectArticle3(userId);
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>博客</title>
<meta name="keywords" content="个人博客模板,博客模板" />
<meta name="description" content="优雅、稳重、大气,低调。" />
<link href="css/index.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
</head>

<body>
<%@ include file="header.jsp" %>
<!--end header-->
<div class="banner">
  <section class="box">
    <ul class="texts">
      <p class="p1">纪念我们:</p>
      <p class="p2">终将逝去的青春</p>
    </ul>
  </section>
</div>
<!--end banner-->
<article>
  <h2 class="title_tj">
    <p>博主<span>推荐</span></p>
  </h2>
  <div class="bloglist left">
<%for(int i=0;(i<articleList.size())&&(i<5);i++){
Article article =new Article();
article=(Article)articleList.get(i);
int TypeId=article.getTypeId();
String type=null;
if(TypeId==1){
type="情感";
}else if(TypeId==2){
type="搞笑";
}else if(TypeId==3){
type="日记";
}else if(TypeId==4){
type="娱乐";
}else if(TypeId==5){
type="旅游";
}else{
type="其它";
}
%>
   <!--wz-->
    <div class="wz">
    <h3><%=article.getTitle() %></h3>
    <p class="dateview"><span><%=article.getPublishTime() %></span><span>分类：[<a href="articleManage?typeId=<%=article.getTypeId()%>"><%=type%></a>]</span></p>
    <ul>
 
        <p> <%=article.getContent() %></p>


      <a title="阅读全文"  href="/2013121182Blog/allContent.jsp?articleId=<%=article.getArticleId()%>" target="_blank" class="readmore">阅读全文>></a>
    </ul>
    <div class="clear"></div>
    </div>
 
   <!--end-->
  
  <%} %>
  </div>
  <!--right-->
  <aside class="right"> 
    <div class="my">
     <h2>关于<span>博主</span></h2>
     <img src="images/my.jpg" width="200" height="200" alt="博主">
       <ul>
        <li>博主：<%=username %></li>
        <li>职业:web前端、网站运营</li>
        <li>简介：一个不断学习和研究，web前端和SEO技术的90后草根站长.</li>
        <li></li>   
       </ul>
    </div>
    <div class="bdsharebuttonbox"><a href="#" class="bds_more" data-cmd="more"></a><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a></div>
    <div class="news">
    <h3 class="ph">
      <p>我的<span>好友</span></p>
    </h3>
    <form name="form" method="post" action="friend">
         <div align="left">
											<td bgcolor="#FFFFFF">
												<div align="right">
								<select name="friendId" class="inputinput">
							<%
								for(int i=0;i<list.size();i++){ 
								Friend friend=(Friend)list.get(i);
								%>
									<option value="<%=friend.getFriendId()%>"><%=friend.getfName() %></option>
								<%} %>
													</select>
												</div>
												<div class="form_row">
                             <input type="submit" class="register" value="确定" />
                    </div> 
                    <div class="form_row">
												</form>
												<li><a href="/2013121182Blog/friendManage.jsp"  target="_blank">管理好友</a></li>
    </ul>
      			<%if(request.getAttribute("result")!=null){
			out.print(request.getAttribute("result"));
			} %>
    <h3>
      <p>用户<span>关注</span></p>
    </h3>
    <ul class="rank">
      <li><a href="/" title="如何建立个人博客" target="_blank">如何建立个人博客</a></li>
      <li><a href="/" title="一个网站的开发流程" target="_blank">一个网站的开发流程</a></li>
      <li><a href="/" title="关键词排名的三个时期" target="_blank">关键词排名的三个时期</a></li>
      <li><a href="/" title="做网站到底需要什么?" target="_blank">做网站到底需要什么?</a></li>
      <li><a href="/" title="关于响应式布局" target="_blank">关于响应式布局</a></li>
      <li><a href="/" title="html5标签" target="_blank">html5标签</a></li>
    </ul>
    
    <h3 class="links">
      <p>友情<span>链接</span></p>
    </h3>
    <ul class="website">
      <li><a href="#">个人博客</a></li>
    </ul> 
    </div> 
</article>
<footer>
  <p><span>网站地图</span><span><a href="/">网站统计</a></span></p>
</footer>
<script src="js/nav.js"></script>
<!--百度分享-->
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"1","bdSize":"32"},"share":{},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
</body>
</html>
