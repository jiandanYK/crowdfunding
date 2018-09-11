<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
          	<li><a href="index.jsp">首页</a></li>
          	<li><a href="#">欢迎,${user.getAdminName() }</a></li>
            <li><a href="#" title="修改个人资料和密码的页面">设置</a></li>
            <li><a href="/crowdfunding/zhuan/admin_out" title="退出登录">退出</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
        	<ul class="nav nav-sidebar">
            <li class="active"><a href="/crowdfunding/zhuan/toIndex1">首页</a></li>
           </ul>
          <ul class="nav nav-sidebar">
            <li><a href="/crowdfunding/adminUser/getProAll">所有项目*</a></li>
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
          <h1 class="page-header">今日众筹</h1>

        <div class="jumbotron">
  <h2>今日总众筹资金：<span id="moneyCount" style="color:#4b63bc;font-size: 1.2em;"></span>￥</h2>
  <h5>昨日总众筹资金：2512010￥</h5>
  <%-- <h5>今日总众筹资金：${money }￥</h5> --%>
  <h2>今日新增众筹项目：${count }</h2>
  <h5>昨日新增众筹项目</h5>
  <p><a class="btn btn-primary btn-lg" href="#" role="button">查看详细</a></p>
</div>

          <div><h2 class="sub-header" style="display: inline-block;">实时数据</h2><span style="display: inline-block;">(每10s自动刷新)</span></div>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>时间</th>
                  <th>目的</th>
                  <th>记录</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
              <%-- <c:forEach items="${list }" var="p">
              
                <tr>
                  <td>10秒前</td>
                  <td>${p.pAim }</td>
                  <td>用户${p.pUsername }发起了新的众筹项目${p.pName }</td>
                  <td><a href="/crowdfunding/adminUser/toinfo?pUsername=${p.pUsername }&pId=${p.pId}">查看项目</a></td>
                </tr>
                </c:forEach> --%>
              <!--   <tr>
                  <td>15秒前</td>
                  <td>项目达标</td>
                  <td>众筹项目xxxxx已达标</td>
                  <td><a href="#">查看项目</a></td>
                </tr>
                 <tr>
                  <td>20秒前</td>
                  <td>众筹资金</td>
                  <td>用户xxx参与了众筹项目xxxxx</td>
                  <td><a href="#"></a></td>
                </tr>
                 <tr>
                  <td>1分前</td>
                  <td>项目达标</td>
                  <td>众筹项目xxxxx已达标</td>
                  <td><a href="#">查看项目</a></td>
                </tr>
                  <tr>
                  <td>5分前</td>
                  <td>众筹资金</td>
                  <td>用户xxx参与了众筹项目xxxxx</td>
                  <td><a href="#"></a></td>
                </tr> -->
               
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
		
		<script type="text/javascript" src="${pageContext.request.contextPath }/admin/js/jquery1.12.4.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/admin/css/bootstrap.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/admin/js/countUp.js" ></script>
		<script>
			$(document).ready(function() {
				var options = {
					useEasing: true,
					useGrouping: true,
					separator: ',',
					decimal: '.',
				};
				var money=${money};
				var demo = new CountUp('moneyCount', 10000, money, 0, 2.5, options);
				if(!demo.error) {
					demo.start();
				} else {
					console.error(demo.error);
				}
			});
			
			
	$(function(){
    getProByTime();
    setInterval(function(){getProByTime()},10000);
    function getProByTime(){
    $("table tbody").html('').fadeIn("slow");


	$.ajax({
	type:"post",
	url:"${pageContext.request.contextPath }/adminUser/getProByTime",
	success:function(d){
	//alert("000000000000");
	$("table tbody").show("slow");
	var tt=$("table tbody");
	for(var i=0;i<d.length;i++){
	if(d[i].second<60){
	tt.append("<tr><td>"+d[i].second+"秒前</td><td>"+d[i].pAim+"</td><td>用户 <strong> <em>"+d[i].pUsername+"</em> 发起了新的众筹项目<strong>"+d[i].pName+"</strong> </td><td><a href='/crowdfunding/adminUser/toinfo?pUsername="+d[i].pUsername+"+&pId="+d[i].pId+"'>查看项目</a></td></tr>");
	}else if(d[i].second>=60&&d[i].second<3600){
	tt.append("<tr><td>"+Math.floor(d[i].second/60)+"分"+Math.floor(d[i].second%60)+"秒前</td><td>"+d[i].pAim+"</td><td>用户 <strong> <em>"+d[i].pUsername+"</em> 发起了新的众筹项目<strong>"+d[i].pName+"</strong> </td><td><a href='/crowdfunding/adminUser/toinfo?pUsername="+d[i].pUsername+"+&pId="+d[i].pId+"'>查看项目</a></td></tr>");
	}else if(d[i].second>=3600&&d[i].second<3600*24){
	tt.append("<tr><td>"+Math.floor(d[i].second/3600)+"时"+Math.floor(d[i].second/60%60)+"分前</td><td>"+d[i].pAim+"</td><td>用户 <strong> <em>"+d[i].pUsername+"</em> 发起了新的众筹项目<strong>"+d[i].pName+"</strong> </td><td><a href='/crowdfunding/adminUser/toinfo?pUsername="+d[i].pUsername+"+&pId="+d[i].pId+"'>查看项目</a></td></tr>");
	}else if(d[i].second>=3600*24&&d[i].second<3600*24*30){
	tt.append("<tr><td>"+Math.floor(d[i].second/3600/24)+"天"+Math.floor(d[i].second/3600%24)+"时前</td><td>"+d[i].pAim+"</td><td>用户 <strong> <em>"+d[i].pUsername+"</em> 发起了新的众筹项目<strong>"+d[i].pName+"</strong> </td><td><a href='/crowdfunding/adminUser/toinfo?pUsername="+d[i].pUsername+"+&pId="+d[i].pId+"'>查看项目</a></td></tr>");
	}else if(d[i].second>=3600*24*30){
	tt.append("<tr><td>"+Math.floor(d[i].second/3600/24/30)+"月"+Math.floor(d[i].second/3600/24%30)+"天前</td><td>"+d[i].pAim+"</td><td>用户 <strong> <em>"+d[i].pUsername+"</em> 发起了新的众筹项目<strong>"+d[i].pName+"</strong> </td><td><a href='/crowdfunding/adminUser/toinfo?pUsername="+d[i].pUsername+"+&pId="+d[i].pId+"'>查看项目</a></td></tr>");
	}
// 	var a="<tr><td>"+d[i].prodescribe+"</td><td>用户 <strong> <em>"+d[i].aboutme+"</em><> 发起了新的众筹项目<strong>"+d[i].proname+"</strong> </td><td><a href='#'>查看项目</a></td></tr>"
// 	$("table tbody").append(a)
     }
     }
	}); 
}
});
						
		</script>
	</body>
</html>
