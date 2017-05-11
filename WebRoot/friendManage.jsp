<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<jsp:directive.page import="java.util.List"/>
<jsp:directive.page import="DataBean.Friend"/>
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
<title>好友管理</title>
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
<jsp:useBean id="friendDao" class="Dao.friendDao" scope="page"></jsp:useBean>
<%
Integer userId=(Integer)session.getAttribute("userId");
List list =friendDao.queryFriend(userId);
 %>

<script type="text/javascript">
function deleteForm(id){
if(confirm("确定要删除此好友吗？")){
window.location.href="friendDel?id="+id;
}
}
</script>





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
          <table width="486" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#FECE62">
            <tr>
              <td width="94" height="25"><div align="center">好友</div></td>
              <td width="133"><div align="center">操作</div></td>
            </tr>
            
         <%for(int i=0;i<list.size();i++){ 
         Friend friend=(Friend)list.get(i);          
         %>   
            <tr bgcolor="#FFFFFF">
              <td height="25"><div align="center"><a href="friend?friendId=<%=friend.getFriendId()%>"><%=friend.getfName()%></a></div></td>
              <td><div align="center">&nbsp;&nbsp;<a href="javascript:deleteForm('<%=friend.getId() %>')">删除</a></div></td>
            </tr>
			<%} %>
			<a href="friendAdd.jsp">添加好友</a>
			<a href="index.jsp">返回首页</a>
			<%if(request.getAttribute("result")!=null){out.print(request.getAttribute("result"));} %>
          </table>  
		  </td>
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
