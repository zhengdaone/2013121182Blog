<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<jsp:directive.page import="java.util.List"/>
<jsp:useBean id="pType" class="Dao.photoTypeDao"></jsp:useBean>
<%@ page import="DataBean.*" %>
<%
int articleId=(Integer)request.getAttribute("articleId");
List list=pType.selectPType();
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="CSS/style.css">
<script language="javascript" type="text/javascript" src="JS/validate.js"></script>
<title>添加图片</title>
<style type="text/css">
<!--
body {
	background-color: #F0F0F0;
}
.style1 {
	color: #FF0000;
	font-weight: bold;
}
-->
</style>
</head>
<body>
<table width="500" border="0" align="center" cellpadding="0" cellspacing="0" background="images/back1.gif">
  <tr>
    <td width="800" valign="top"><table width="227" border="0" cellpadding="0" cellspacing="0">
    </table>
      <table width="570" border="0" cellpadding="0" cellspacing="0" background="images/back_noword_05.jpg">
        <tr>
          <td valign="top" align="center">		
		  
		  <%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;相片上传</p>");%>
		  <form action="BlogPhoto" method="post"  enctype="multipart/form-data">
		  
            <table width="500" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#FECE62">
              <tr>
                <td width="200" height="30"><div align="center">上传图片：</div></td>
                <td width="400" bgcolor="#FFFFFF">
                    <div align="left">
                      <input name="photoAddress" type="file" class="inputinput"  size="30">
                      <input name="articleId" type="hidden" class="inputinput"  size="40" value="<%=articleId%>">
                  </div></td></tr>
                  </div>
											</td>
											 <tr>
											<td height="30">
												<div align="center">
													图片类别：
												</div>
											</td>
											<td bgcolor="#FFFFFF">
												<div align="center">
								<select name="typeId" class="inputinputinput">
							<%
								for(int i=0;i<list.size();i++){ 
								photoType form=(photoType)list.get(i);								
								%>
									<option value="<%=form.getpTypeId()%>"><%=form.getpTypeName() %></option>									
								<%} %>
													</select>
												</div>
											</td>
										</tr>
            </table>
            <table width="494" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="494">
				<br>
				<div align="center" class="style1">注意：图片的格式只能为：“jpg”,“gif”</div></td>				                                                                             												
              </tr>
            </table>
            <br>
 <input type="image" class="inputinputinput" src="images/save.gif">
&nbsp;&nbsp;
 <input type="button" onclick="location='allContent.jsp?articleId=${requestScope.articleId}'" value="返回文章">
            </form>
			
			<%if(request.getAttribute("result")!=null){
			out.print(request.getAttribute("result"));
			} %></td>
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
