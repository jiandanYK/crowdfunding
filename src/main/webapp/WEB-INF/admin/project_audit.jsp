<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'project_audit.jsp' starting page</title>

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
    <a href="/crowdfunding/adminUser/index">返回首页</a><hr> 
    <span style="color:red">${map.get("info") }</span>
	<table border="1px">
		<tr>
			<th>序号</th>
			<th>项目类型</th>			
            <th>项目名称</th>
            <th>项目进度</th>
            <th>开始日期</th>
            <th>结束日期</th>
            <th>已筹金额</th>
            <th>发起人</th>
            <th>当前状态</th>
            <th>操作</th>
            </tr>
    
          <c:forEach items="${list }" var="p">
                <tr>
                  <td>${p.pId }</td>
                  <td>${p.getProclass().getcName() }</td>
                  <td>${p.pName }</td>
                  <fmt:formatNumber value="${p.pRaise*1.0/p.pMoney*100 }" type="number" var="d" pattern="#.##"></fmt:formatNumber>                                      
                  <td>${d }%</td>
                  <fmt:formatDate value="${p.pStime }" pattern="yyyy/MM/dd" var="d1" />
                  <td>${d1 }</td>
                  <fmt:formatDate value="${p.pEtime }" pattern="yyyy/MM/dd" var="d2" />
                  <td>${d2 }</td>
                  <td>${p.pRaise }￥</td>
                  <td>${p.pUsername }</td>
                  <td>${p.pState }</td>
                  <td>
                  <a href="/crowdfunding/adminUser/toPass?id=${p.pId }">项目通过</a>
                  <a href="/crowdfunding/adminUser/toDel?id=${p.pId }">项目失败</a>
                  </td>
                  </tr>
                  </c:forEach>
	    
    </table>
  </body>
</html>
