<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../CSS/style.css" type="text/css" rel="stylesheet">
<script language="javascript" type="text/javascript" src="../JS/validate.js"></script>
<title>用户登录</title>
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
	
	<form name="form" method="post" action="consumerLogin" >

  <table width="357" border="0" align="center">
    
    <tr>
      <td width="78" height="30">用户名：</td>
      <td width="263"><input name="username" type="text" class="inputinput" size="40" ></td>
    </tr>
    <tr>
      <td height="30">密码：</td>
      <td><input name="password" type="password" class="inputinput"  size="40"></td>
    </tr>
      <td height="30" colspan="2" align="center">
<div class="form_row">
                    <input type="submit" class="inputinputinput" value="登录" />
                     <input type="button" value="注册" onclick="location='register.jsp'"/>
                     <input type="button" class="hidden" onclick="location='consumerLogin?username=<%="游客"%>'" value="游客" />
                    </div> 
       </td>
    </tr> 
  </table></form>
	</td>
  </tr>
</table>
</div>
</body>
</html>
