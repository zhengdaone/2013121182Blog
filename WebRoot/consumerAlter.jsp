<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@page import="Dao.commentDao"%>
<%@page import="DataBean.Consumer"%>
<%@ page import="DataBean.Consumer" %>
<jsp:useBean id="consumerDao" scope="page" class="Dao.consumerDao"></jsp:useBean>
<%
String userName=(String)session.getAttribute("username");
if(userName==null){
response.sendRedirect("Login.jsp");
}

 %>
<%
String username=(String)session.getAttribute("username");
Consumer consumer=consumerDao.selectUser(username);
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../CSS/style.css" type="text/css" rel="stylesheet">
<script language="javascript" type="text/javascript" src="../JS/validate.js"></script>
<title>用户修改</title>
<style type="text/css">

</style></head>

<body style="background-image:url(images/bgRegister.jpg);background-position:center; background-repeat:repeat-y">
<div align="center">

<table width="800" height="689" border="0" cellpadding="0" cellspacing="0" background="../images/enrol.jpg">
  <tr>
    <td>
	
	
	
	  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
	
	<form name="form" method="post" action="consumerAlter" >

  <table width="357" border="0" align="center">
    
    <tr>
      <td width="78" height="30">用户名：</td>
      <td width="263"><input name="username" type="text" class="inputinput" readonly onClick="alert('此文本框已设为只读，用户不能修改')" size="40" value="<%=consumer.getUsername() %>"></td>
    </tr>
    <tr>
      <td height="30">密码：</td>
      <td><input name="password" type="password" class="inputinput"  size="40"></td>
    </tr>
    <tr>
      <td height="30">重复密码：</td>
      <td><input name="pwdConfirm" type="password" class="inputinput"  size="40"></td>
    </tr>
    <tr>
      <td height="30">性别：</td>
      <td><input name="sex" type="radio" class="inputinputinput" value="男" checked>
        男
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input name="sex" type="radio" class="inputinputinput" value="女"> 
        女 </td>
    </tr>
    <tr>
      <td height="30">E-mail：</td>
      <td><input name="email" type="text" class="inputinput"  size="40"></td>
      <td><input name="userId" type="hidden" class="inputinput"  size="40" value="<%=consumer.getUserId()%>"></td>
    </tr>
    <tr>
      <td height="30" colspan="2" align="center">
<div class="form_row">
                    <input type="submit" class="register" value="修改" />
   <input type="button" onclick="location='about.jsp'"  value="返回">
   <input type="button" onclick="location='index.jsp'"  value="首页">
                    </div> 
       </td>
    </tr> 
  </table>
	</form>
  </tr>
</table>
</div>
</body>
</html>
