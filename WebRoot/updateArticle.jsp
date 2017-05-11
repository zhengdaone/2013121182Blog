<%@page import="Dao.articleTypeDao"%>
<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<jsp:directive.page import="DataBean.*" />
<jsp:directive.page import="java.util.*" />
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
		<script language="javascript" type="text/javascript"
			src="JS/validate.js"></script>
		<title>文章修改</title>
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
	<jsp:useBean id="articleDao" class="Dao.articleDao" scope="request"></jsp:useBean>
	<jsp:useBean id="articleTypeDao" scope="page" class="Dao.articleTypeDao"></jsp:useBean>
<%
List list=articleTypeDao.queryArticleType();
%>
<%
int articleId = Integer.parseInt(request.getParameter("id"));
Article article=articleDao.queryArticle(articleId);
 %>


	<body>

		<table width="800" border="0" align="center" cellpadding="0"
			cellspacing="0" background="images/back1.gif">
			<tr>
				<td width="227" valign="top">

				</td>
				<td width="573" valign="top">
					<table width="227" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<img src="images/back_noword_03.jpg" width="573" height="25">
							</td>
						</tr>
					</table>
					<table width="573" border="0" cellpadding="0" cellspacing="0"
						background="images/back_noword_05.jpg">
						<tr>
							<td valign="top" align="center">

								<%out.println("<p align=left>&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/icon.gif width=10 height=10>&nbsp;&nbsp;文章修改</p>");%>
								<form name="form" method="post" action="articleUpd">

									<table width="340" border="1" cellpadding="1" cellspacing="1"
										bordercolor="#FFFFFF" bgcolor="#FECE62">
										<tr>
											<td width="77" height="30">
												<div align="center">
													文章主题：
												</div>
											</td>
											<td width="250" bgcolor="#FFFFFF">
												<div align="center">
													<input name="title" type="text" class="inputinput"
														size="30" value="<%=article.getTitle() %>">														
												</div>
											</td>
										</tr>
										<tr>
											<td height="30">
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
												</div>
											</td>
										</tr>

										<tr>
											<td height="30">
												<div align="center">
													文章内容：
												</div>
											</td>
											<td bgcolor="#FFFFFF">
												<div align="center">
													<textarea name="content" cols="28" rows="20"
														class="inputinput"><%=article.getContent()%></textarea>
												</div>
											</td>
										</tr>
										<tr>
											<td height="30">
												<div align="center">
													发布时间：
												</div>
											</td>
											<td bgcolor="#FFFFFF">
												<div align="center">
													<input name="phTime" type="text" class="inputinput"
														
														readonly="readonly" onclick="alert('此文本框已设为只读，用户不能修改')" value="<%=article.getPublishTime() %>">
												</div>
											</td>
										</tr>


										<tr>
											<td height="30">
												<div align="center">
													文章编号：
												</div>
											</td>
											<td bgcolor="#FFFFFF">
												<div align="center">
													<input name="articleId" type="text" class="inputinput"
														size="30" readonly="readonly"
														onclick="alert('此文本框已设为只读，用户不能修改')" value="<%=articleId%>">
												</div>
											</td>
										</tr>


									</table>
									<br>
									<input type="image" class="inputinputinput"
										src="images/save.gif">
									&nbsp;&nbsp;
									<input type="button" onclick="location='javascript:history.go(-1);'"  value="返回">
								</form>

								<%
										if (request.getAttribute("result") != null) {
										out.print(request.getAttribute("result"));
									}
								%>
							</td>
						</tr>
					</table>
					<table width="227" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<img src="images/back_noword_18.jpg" width="573" height="21">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
