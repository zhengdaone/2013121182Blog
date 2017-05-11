<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String page2=(String)request.getAttribute("page");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>My JSP 'test.jsp' starting </title>
  </head>
   <script type="text/javascript">
alert(aa);
</script>
  <body>
    <table><c:set var="a">a</c:set>
    <c:out value="a"></c:out>
   <c:forEach items="${list}" var="article" >
   <tr>
   <c:choose>
    <c:when test="${article.content!=null}">
   <td>年龄<c:out value="${article.content }"></c:out></td> 
    </c:when>
    </c:choose>
   <td>a</td>
   <td>a</td>
   <td>a</td>
   <td>a</td> 
   </tr>
   </c:forEach> 
   <%=page2 %>
    </table> <br>
  </body>
</html>
