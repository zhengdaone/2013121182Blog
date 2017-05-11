<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@page import="Dao.commentDao"%>
<%@page import="DataBean.Consumer"%>
<%@ page import="DataBean.Consumer" %>
<jsp:useBean id="consumerDao" scope="page" class="Dao.consumerDao"></jsp:useBean>
<%
String userName=(String)session.getAttribute("username");
if(userName==null||userName.equals("游客")){
String result="无权限访问，请登录或注册";
request.setAttribute("result", result);
request.getRequestDispatcher("register.jsp").forward(request, response);
}

 %>
<%
String username=(String)session.getAttribute("username");
Consumer consumer=consumerDao.selectUser(username);
 %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>关于我</title>
<meta name="keywords" content="个人博客,段亮个人博客,个人博客模板," />
<meta name="description" content="" />
<link href="css/index.css" rel="stylesheet">
<link href="css/ty.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
</head>
<body>
<%@ include file="header.jsp" %>
<article class="aboutcon">
<h1 class="t_nav"><span>像“草根”一样，紧贴着地面，低调的存在，冬去春来，枯荣无恙。</span><a href="/" class="n1">网站首页</a><a href="/" class="n2">关于我</a></h1>
<div class="about left">
  <h2>About me</h2>
  <div id="me_text">
       <p> 一个不断学习和研究，web前端和SEO技术的90后草根站长。</p>
      <p>我属于天蝎座:很多时候觉得自己对待任何事都很执着，一旦定了目标，就会不达目标不罢休，永不退缩！
     面对爱情也是一样，当真正遇到自己喜欢的一个人，会不顾一切去追。</p>
     <p>在学习这条路上，最大的收获就是：自己对待人生观和价值观有了自己独特的看法。同时也感谢Arry老师以及网页制作的老师们，为我们这些VIP学员分享很多干货和知识。 一句很经典的话："授人以鱼不如授人以渔"，讲的是：传授给人知识，不如传授给人学习知识的方法。我觉得不管学什么，好的学习方法，可以使你达到事半功倍的效果。同样 的道理，很多都不愿意花钱去学习，总想着免费的午餐可以吃。这也是人性的一大弱点。试问：本来可以花3个月左右的时间学出来的东西。你却花了1-2年时间才学会。你认为你值吗？ 社会是残酷的，等你学会了这门技术，别人早已经学其它的技术去了。你跟别人相比你的优势在哪里？到最后还是被淘汰。这就是一种思维类的转变，当你把学习看成一种投资，你就绝对不会那么想了。
人就得学会感恩，滴水之恩应当涌泉相报。</p>
   <p>感谢那些曾经帮助过我的人，因为有你们我才会变得如此的优秀。----By:<span style="color:#f00"><%=consumer.getUsername() %></span></p>
  </div>
</div>
<aside class="right">  
    <div class="about_c">
    <p>博主：<span><%=consumer.getUsername() %></span></p>
    <p>星座：天蝎座</p>
    <p>现居：湖南省-长沙市</p>
    <p>博客：<a href="www.duanliang920.com" target="_blank">www.duanliang920.com</a></p>
    <p>喜欢的书：《我的互联网方法论》..</p>
    <p>喜欢的音乐：《一生中最爱》..</p>
    <div class="about_qq"><span>联系博主：</span><a href="http://wpa.qq.com/msgrd?v=3&uin=947580181&site=qq&menu=yes" title="联系博主" target="_blank"><p></p></a>
     <div class="clear"></div>
    </div>
    <div class="about_yx"><span><input type="button" onclick="location='consumerAlter.jsp'"  value="修改信息">
    <div class="clear"></div>
    </div>
</div>     
</aside>
</article>
<footer>
 <p><span>Design By:<a href="www.duanliang920.com" target="_blank"><%=consumer.getUsername() %></a></span><span>网站地图</span><span><a href="/">网站统计</a></span></p>
</footer>
<script src="js/nav.js"></script>
</body>
</html>