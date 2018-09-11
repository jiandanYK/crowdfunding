<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>众筹管理后台</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/dashboard.css" />
	</head>
	<body>
		
		 <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">众筹管理平台</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
        	
          <ul class="nav navbar-nav navbar-right">
          	<li><a href="/crowdfunding/adminUser/index">首页</a></li>
          	<li><a href="#">欢迎,${user.getAdminName() }</a></li>
            <li><a href="#" title="修改个人资料和密码的页面">设置</a></li>
            <li><a href="#" title="退出登录">退出</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
        	<ul class="nav nav-sidebar">
            <li ><a href="/crowdfunding/adminUser/index">首页</a></li>
           </ul>
          <ul class="nav nav-sidebar">
            <li class="active"><a href="/crowdfunding/adminUser/getProAll">所有项目*</a></li>
            <li><a href="/crowdfunding/adminUser/doProAudit">项目审核</a></li>
            <li><a href="#">项目跟踪</a></li>
            <li><a href="#">项目评论</a></li>
            <li><a href="/crowdfunding/adminUser/getProClassAll">项目分类*</a></li>
            <li><a href="#">项目推荐</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">注册用户</a></li>
            <li><a href="">用户资金</a></li>
            <li><a href="">用户日志</a></li>
            <li><a href="">实名审核</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">新闻管理</a></li>
            <li><a href="">问题管理</a></li>
            <li><a href="">管理用户</a></li>
            <li><a href="">管理日志</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">所有众筹项目</h1>

		<div class="panel panel-default">
  <div class="panel-body">
			<form class="form-inline" action="/crowdfunding/adminUser/getProAll">
			  <div class="form-group">
			    <input type="text" class="form-control" name="pName" id="exampleInputName2" placeholder="项目名称">
			  </div>
			   <div class="form-group">
			    <input type="text" class="form-control" name="pUsername" id="exampleInputName2" placeholder="项目发起人">
			  </div>
			  <div class="form-group">
			   <select class=form-control name="pState">
			   	<option>项目状态</option>			   	
			   	<option>众筹中</option>
			   	<option>众筹失败</option>
			   	<option>众筹成功</option>
			   </select>
			  </div>
			   <div class="form-group">
			   <select class=form-control name="cName">
			   	<option>项目类型</option>
			   	
			   	<option>教育助学</option>
			   	<option>爱心环保</option>
			   	<option>扶贫助困</option>
			   	<option>公益创业</option>
			   	<option>公益活动</option>
			   </select>
			  </div>
			  &nbsp;&nbsp;
			  <button type="submit" class="btn btn-default btn-primary">查询</button>
			</form>
    </div>
   </div>
			<div class="panel panel-default">
  <div class="panel-heading">
    <div class="panel-title">
    	所有项目列表
    </div>
  </div>
  <div class="panel-body">
   
          <div class="table-responsive ">
            <table class="table table-striped table-bordered">
              <thead>
                <tr>
                  <th>序号</th>
                  <th>项目类型</th>
                  <th>项目名称</th>
                  <th>项目进度</th>
                  <th>开始日期</th>
                  <th>结束日期</th>
                  <th>已筹金额</th>
                  <th>发起人</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
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
                  <td>
                  <!-- <a href="/crowdfunding/adminUser/getPro">详情</a> -->
                  	<a href="/crowdfunding/adminUser/toinfo?pUsername=${p.pUsername }&pId=${p.pId}">详情</a>
                  	<!--<a href="#" title="查看项目详情"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span></a>-->
                  	<!--&nbsp;&nbsp;
                  	<a href="#" title="编辑项目信息"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>-->
                  </td>
                </tr>
                  </c:forEach>
                     
              </tbody>
            </table>
          </div>

  	             <nav aria-label="Page navigation" class="text-right">
				  <!-- <ul class="pagination">
				    <li class="disabled">
				      <a href="#" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    
				    <li class="active"><a href="#">1</a></li>
				    <li><a href="#">2</a></li>
				    <li><a href="#">3</a></li>
				    <li><a href="#">4</a></li>
				    <li><a href="#">5</a></li>
				    <li>
				      <a href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul> -->
				  
				  <c:url var="frist" value="/adminUser/getProAll">
					<c:param name="pageIndex" value="1"></c:param>
					<%-- <c:param name="pay" value="${pay }"></c:param> --%>
				</c:url>
				<c:url var="next" value="/adminUser/getProAll">
					<c:param name="pageIndex" value="${pageIndex-1 }"></c:param>
					<%-- <c:param name="pay" value="${pay }"></c:param> --%>
				</c:url>
				<c:url var="last" value="/adminUser/getProAll">
					<c:param name="pageIndex" value="${pageIndex+1 }"></c:param>
					<%-- <c:param name="pay" value="${pay }"></c:param> --%>
				</c:url>
				<c:url var="fina" value="/adminUser/getProAll">
					<c:param name="pageIndex" value="${page }"></c:param>
					<%-- <c:param name="pay" value="${pay }"></c:param> --%>
				</c:url>
						<c:if test="${pageIndex!=1 }">
						    <a href="${frist }">首页</a>
							<a href="${next }">上一页</a>
						</c:if> 
						<c:if test="${pageIndex!=page }">
							<a href="${last }">下一页</a>
							<a href="${fina }">末页</a>
						</c:if>
				</nav>   	
  </div>
 

</div>
      
        </div>
      </div>
    </div>
		
		<script type="text/javascript" src="${pageContext.request.contextPath }/admin/js/jquery1.12.4.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/admin/js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/admin/js/countUp.js" ></script>
		<script>
			$(document).ready(function() {
				
			});
		</script>
	</body>
</html>
