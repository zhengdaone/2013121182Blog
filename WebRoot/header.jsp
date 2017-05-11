<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<header>
  <div id="logo"><a href="index.jsp"></a></div>
   <nav class="topnav" id="topnav">
          <form name="form" method="post" action="search">
   <input type="text" id="searchstr" name="searchstr" class="textbox" size="20">  
   <input type="submit" value="查询文章" >
   </form>
  <a href="index.jsp"><span>首页</span><span class="en">Home</span></a>
  <a href="allBlog.jsp"><span>我的博客</span><span class="en">Blog</span></a>
  <a href="photo.jsp"><span>我的相册</span><span class="en">photo</span></a>
  <a href="about.jsp"><span>关于我</span><span class="en">About</span></a>
  <a href="sessionInvalidate.jsp"><span>退出登录</span><span class="en">Quit</span></a>
  </nav>
</header>