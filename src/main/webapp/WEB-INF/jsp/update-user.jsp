<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update-user.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
     <a href="/crowdfunding/zhuan/toIndex">返回首页</a><hr>
     <form action="/crowdfunding/user/update" method="get">
	 
		<table width="800px" height="300px" border="1px">
			<tr>
				<td class="field">用户id：</td>
				<td><input type="text" name="uId" class="text" readonly="readonly"
					value="${user.uId }" />
				</td>
			</tr>
			<tr>
				<td class="field">联系方式：</td>
				<td><input type="text" name="uPhone" class="text"
					value="${user.uPhone }" />
				</td>
			</tr>
			<tr>
				<td class="field">邮箱：</td>
				<td><input type="text" name="uEmail" class="text"
					value="${user.uEmail }" />
				</td>
			</tr>
			<tr>
				<td class="field">密码：</td>
				<td><input type="text" name="uPwd" class="text"
					value="${user.uPwd }" />
				</td>
			</tr>
			<tr>
				<td class="field">用户姓名：</td>
				<td><input type="text" name="uName" class="text"
					value="${user.uName }" />
				</td>
			</tr>
			<tr>
				<td class="field">身份证：</td>
				<td><input type="text" name="uIdentity" class="text"
					value="${user.uIdentity}" />
				</td>
			</tr>
			<tr>
				<td class="field">性别：</td>
				<td><input type="text" name="uSex" class="text"
					value="${user.uSex }" />
				</td>
			</tr>
			<tr>
				<td class="field">出生年月：</td>
				<td>
				<fmt:formatDate value="${user.uBirthday }" pattern="yyyy/MM/dd" var="date"/>
				<input type="text" name="uBirthday" class="text"
					value="${date }" />
				</td>
			</tr>
			<tr>
				<td class="field">账户余额：</td>
				<td><input type="text" name="uMoney" class="text"
					value="${user.uMoney }" />
				</td>
			</tr>
		</table>
		<input type="submit" value="提交" ><input type="reset" value="重置">
	</form>
  
  </body>
</html>
