<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/dashboard.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/dialog.css" />
</head>

<body>
<!--上部导航栏start-->
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
                <li><a href="index.html">首页</a></li>
                <li><a href="#">欢迎,${user.getAdminName() }</a></li>
                <li><a href="#" title="修改个人资料和密码的页面">设置</a></li>
                <li><a href="#" title="退出登录">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
<!--上部导航栏end-->
<div class="container-fluid">
    <div class="row">
        <!--左侧导航栏start-->
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li ><a href="index.html">首页</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="/crowdfunding/adminUser/getProAll">所有项目*</a></li>
                <li><a href="/crowdfunding/adminUser/doProAudit">项目审核</a></li>
                <li><a href="#">项目跟踪</a></li>
                <li><a href="#">项目评论</a></li>
                <li class="active"><a href="/crowdfunding/adminUser/getProClassAll">项目分类*</a></li>
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
        <!--左侧导航栏end-->
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">众筹项目分类</h1>

            <div class="panel panel-default">
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="panel-title">
                        项目分类列表  <a class="btn btn-primary" href="/crowdfunding/adminUser/toAdd">添加</a>
                    </div>
                </div>
                <div class="panel-body">

                    <div class="table-responsive ">
                        <table class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>分类名称</th>
                                <th>分类描述</th>
                                <th>添加时间</th>
                                <th>分类状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${list }" var="pc">
                            <tr>
                                <td>${pc.cId }</td>
                                <td>${pc.cName }</td>
                                <td>${pc.cDesc }</td>
                                <fmt:formatDate value="${pc.cTime }" pattern="yyyy-MM-dd" var="d" />
                                <td>${d }</td>
                                <c:if test="${pc.cState==1 }">
                                <td>可用</td>
                                </c:if>
                                <c:if test="${pc.cState==0 }">
                                <td>禁用</td>
                                </c:if>
                                <td>
                                    <a href="#" data-toggle="modal"
                                       data-target="#myModal" onclick="getTable('${pc.cId }','${pc.cName }','${pc.cDesc }','${d }','${pc.cState==0?'禁用':'可用' }')">详情/修改</a> |
                                    <a href="#" onclick="getdel('${pc.cId }')">删除</a>
                                     <%-- <a href="#" data-toggle="modal"
                                       data-target="#myModal" onclick="getTable('${c.id}','${c.name }','${c.describe }',
                                       '<fmt:formatDate value="${c.createtime }" pattern="yyyy-MM-dd"/>','${c.state==0?'禁用':'可用' }')">详情/修改</a> --%>                                  
                                </td>
                            </tr>
                            </c:forEach>
                            <!-- <tr>
                                <td>2</td>
                                <td>互联网众筹</td>
                                <td>XXXXXXXXXXXXXXXXXX</td>
                                <td>2018-05-11</td>
                                <td>可用</td>
                                <td>
                                    <a href="#" data-toggle="modal"
                                       data-target="#myModal" onclick="getTable(2,'互联网众筹','XXXXXXXXXXX','2018-05-11','可用')">详情/修改</a> |
                                    <a href="#" onclick="getdel(2)">删除</a>
                                </td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>金融众筹</td>
                                <td>XXXXXXXXXXXXXXXXXX</td>
                                <td>2018-05-11</td>
                                <td>禁用</td>
                                <td>
                                    <a href="#" data-toggle="modal"
                                       data-target="#myModal" onclick="getTable(3,'金融众筹','XXXXXXXXXXX','2018-05-11','禁用')">详情/修改</a> |
                                    <a href="#" onclick="getdel(3)">删除</a>
                                </td>
                            </tr> -->
                            </tbody>
                        </table>
                    </div>
                    <!--模态框-->
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                         aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="myModalLabel">分类详情</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form">
                                        <form class="form-validate form-horizontal" id="feedback_form"
                                              method="get"  action="/crowdfunding/adminUser/update">
                                            <div class="form-group ">
                                                <label for="p_id" class="control-label col-lg-2">序号<span
                                                        class="required"> *</span></label>
                                                <div class="col-lg-10">
                                                    <input name="cId" class="form-control" id="p_id" type="text" readonly />
                                                </div>
                                            </div>

                                            <div class="form-group ">
                                                <label for="p_name" class="control-label col-lg-2">分类名称<span
                                                        class="required"> *</span></label>
                                                <div class="col-lg-10">
                                                    <input name="cName" class="form-control" id="p_name" type="text" />
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="p_des" class="control-label col-lg-2">分类描述<span
                                                        class="required"> *</span></label>
                                                <div class="col-lg-10">
                                                    <input name="cDesc" class="form-control" id="p_des" type="text" />
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="p_time" class="control-label col-lg-2">添加时间<span
                                                        class="required"> *</span></label>
                                                <div class="col-lg-10">
                                                    <input name="cTime" class="form-control" id="p_time" type="text" readonly />
                                                </div>
                                            </div>

                                            <div class="form-group ">
                                                <label for="p_status" class="control-label col-lg-2">分类状态<span
                                                        class="required"> *</span></label>
                                                <div class="col-lg-10">
                                                    <select name="cState" class="form-control m-bot15" id="p_status">
                                                        <option value="1">可用</option>
                                                        <option value="0">禁用</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group" style="text-align: right;">
                                                <div class="col-lg-offset-2 col-lg-10">
                                                    <!-- <button class="btn btn-primary" type="button" onclick="getmodify()">保存</button> -->
                                                    <button class="btn btn-primary" type="submit" >保存</button>
                                                    <button class="btn btn-default" type="reset">重置</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <nav aria-label="Page navigation" class="text-right">
                         <c:url var="frist" value="/adminUser/getProClassAll">
					<c:param name="pageIndex" value="1"></c:param>
					<%-- <c:param name="pay" value="${pay }"></c:param> --%>
				</c:url>
				<c:url var="next" value="/adminUser/getProClassAll">
					<c:param name="pageIndex" value="${pageIndex-1 }"></c:param>
					<%-- <c:param name="pay" value="${pay }"></c:param> --%>
				</c:url>
				<c:url var="last" value="/adminUser/getProClassAll">
					<c:param name="pageIndex" value="${pageIndex+1 }"></c:param>
					<%-- <c:param name="pay" value="${pay }"></c:param> --%>
				</c:url>
				<c:url var="fina" value="/adminUser/getProClassAll">
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
<script type="text/javascript" src="${pageContext.request.contextPath }/admin/js/dialog.js" ></script>
<script>
    function getTable(p_id,p_name,p_des,p_time,p_status){
        document.getElementById("p_id").value=p_id;
        document.getElementById("p_name").value=p_name;
        document.getElementById("p_des").value=p_des;
        document.getElementById("p_time").value=p_time;
        document.getElementById("p_status").value=p_status;
    } 
   /*  function getmodify(){
          window.location.href="/crowdfunding/adminUser/update";   
    } */
    
     function getdel(id){
        javascript:$('body').dailog({type:'danger',title:'错误.',discription:'您确定要删除ID为'+id+'的数据吗?'},
            function(ret) {
                if(ret.index===0){
                    window.location.href="/crowdfunding/adminUser/del?id="+id;
                };
            })
   }
   
</script>

</body>
</html>