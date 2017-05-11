<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<jsp:directive.page import="DataBean.Friend"/>
<jsp:directive.page import="java.util.List"/>
<%
String username=(String)session.getAttribute("username");
if(username==null){
response.sendRedirect("Login.jsp");
}

 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="CSS/style.css">
<script language="javascript" type="text/javascript" src="JS/validate.js"></script>
<title>添加好友</title>
<style type="text/css">
<!--
.style1 {color: #FFCD00}
.style2 {
	color: #a54400;
	font-weight: bold;
}
body {
	background-color: #F0F0F0;
}
.style4 {color: #666666}
-->
</style>
</head>






<body>
<table width="800" border="0" align="center" cellpadding="0" cellspacing="0" background="images/back1.gif">
  <tr>
    <td width="573" valign="top"><table width="227" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="images/back_noword_03.jpg" width="573" height="25"></td>
      </tr>
    </table>
      <table width="573" border="0" cellpadding="0" cellspacing="0" background="images/back_noword_05.jpg">
        <tr>
          <td valign="top" align="center">		
		  
		  <%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/icon.gif width=10 height=10>&nbsp;&nbsp;朋友添加</p>");%><a href="index.jsp">返回首页</a>
		  <%if(request.getAttribute("result")!=null){out.print(request.getAttribute("result"));} %>
		  <form name="form" method="post" action="friendAdd">
		  
            <table width="340" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#FECE62">
              <tr>
                <td width="72" height="30"><div align="center">用户名：</div></td>
                <td width="255" bgcolor="#FFFFFF"><div align="center">
                  <input name="fName" type="text" class="inputinput"  size="30">
                </div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">用户ID：</div></td>
                <td bgcolor="#FFFFFF"><div align="center">
                  <input name="friendId" type="text" class="inputinput"  size="30">
                </div></td>
              </tr>                     
            </table>
            <br>
            <input type="image" class="inputinputinput" src="images/save.gif">
            </form>
			
			<input type="button" onclick="location='javascript:history.go(-1);'"  value="返回">
        </tr>
      </table>
      <table width="227" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><img src="images/back_noword_18.jpg" width="573" height="21"></td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>
