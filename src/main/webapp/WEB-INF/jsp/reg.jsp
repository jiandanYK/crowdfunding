<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.42.min.js"></script>
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath }/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/css/base.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/css/reg.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/headbott.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/ace.min.css"
	type="text/css" />
</head>

<body>
	<div id="header">
		<div class="heade-con">
			<div class="logo">
				<a href=""><img
					src="${pageContext.request.contextPath }/images/LOGO.png" /> </a>
			</div>
			<div class="nav posa">
				<ul>
				<li><a class="vcolor" href="/crowdfunding/zhuan/toIndex">首页</a></li>
                <li><a href="/crowdfunding/zhuan/to_gyzc-list">公益众筹</a></li>
                <li><a href="/crowdfunding/zhuan/to_cop">常见问题</a></li>
                <li><a href="/crowdfunding/zhuan/to_ly-list">众筹资讯</a></li>
                <li><a href="/crowdfunding/zhuan/to_new_info" style="">发布项目</a></li>
				</ul>
			</div>
			<div class="search">
				<form action="">
					<input type="text" class="search-txt" value="找项目"> <input
						type="submit" class="search-but" value="">
				</form>
			</div>
			<div class="index-login">
			<c:if test="${user!=null }">
            <a href="/crowdfunding/user/to_user?uName=${user.getuName() }">个人中心</a>
            </c:if>
        	<c:if test="${user==null }">
            <a href="/crowdfunding/zhuan/userLogin">登录</a>    
            </c:if>
				<!-- <a href="/crowdfunding/zhuan/userLogin">登录</a> --> 
				<a class="index-login1" href="/crowdfunding/zhuan/reg">注册</a>
			</div>
		</div>
	</div>
	<div class="login-container">

		<div class="space-6"></div>

		<div class="position-relative">
			<div id="signup-box" class="signup-box widget-box no-border">
				<div class="widget-body">
					<div class="widget-main">
						<h4 class="header green lighter bigger">
							<i class="ace-icon fa fa-users blue"></i> 用户注册
						</h4>

						<div class="space-6"></div>
						<p>填写信息:</p>

						<form action="/crowdfunding/user/togo">
							<fieldset>
								<label class="block clearfix"> <span
									class="block input-icon input-icon-left"> <input
										name="uPhone" id="email" 
										type="text" class="form-control" placeholder="邮箱或手机号码" /> <i
										class="ace-icon fa fa-envelope"></i> </span> </label> <label
									class="block clearfix"> <span
									class="block input-icon input-icon-left"> <input
										name="uName" id="uname"  type="text"
										class="form-control" placeholder="用户名" /> <i
										class="ace-icon fa fa-user"></i> </span> </label> <label
									class="block clearfix"> <span
									class="block input-icon input-icon-left"> <input
										name="uPwd" type="password" class="form-control"
										placeholder="密码" /> <i class="ace-icon fa fa-lock"></i> </span> </label> <label
									class="block clearfix"> <span
									class="block input-icon input-icon-left"> <input
										name="uPwd" type="password" class="form-control"
										placeholder="确认密码" /> <i class="ace-icon fa fa-retweet"></i>
								</span> </label>
								<!--验证码-->
								
								<label class="block clearfix"> <span> <input  
										name="uCode" type="text"  placeholder="验证码" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button type="button" class="btn btn-default"  onclick="sendMessage()">
											<a>点击获取验证码</a>
										</button> </span> </label> <label class="block"> <input type="checkbox"
									class="ace" /> <span class="lbl"> 接受 <a href="#">用户协议</a>
								</span> </label>

								<div class="space-24"></div>

								<div class="clearfix">
									<button type="reset" class="width-30 pull-left btn btn-sm">
										<i class="ace-icon fa fa-refresh"></i> <span
											class="bigger-110">重置</span>
									</button>

									<button type="submit"
										class="width-65 pull-right btn btn-sm btn-success">
										<span class="bigger-110">注册</span> <i
											class="ace-icon fa fa-arrow-right icon-on-right"></i>
									</button>
								</div>
							</fieldset>
						</form>
						<!--第三方-->
						<div class="social-or-login center">
							<span class="bigger-110">第三方登录</span>
						</div>

						<div class="space-6"></div>

						<div class="social-login center">
							<a href="#"> <img
								src="${pageContext.request.contextPath }/images/weixin.png">
							</a> <a href="#"> <img
								src="${pageContext.request.contextPath }/images/qq.png"> </a>
							<a href="#"> <img
								src="${pageContext.request.contextPath }/images/sina.png">
							</a>
						</div>
					</div>

					<div class="toolbar center">
						<a href="login.html" data-target="#login-box"
							class="back-to-login-link"> <i
							class="ace-icon fa fa-arrow-left"></i> 返回登录 </a>
					</div>
				</div>
				<!-- /.widget-body -->
			</div>
		</div>
	</div>
	</div>
	<div id="bottom">
		<div class="bottom-ggt">
			<a href=""><img
				src="${pageContext.request.contextPath }/images/bottbom_68.jpg"
				alt="" /> </a>
		</div>
		<div class="zc-yqlink">
			<ul>
				<li><a href="">阿里巴巴集团</a></li>
				<li><a href="">淘宝网</a></li>
				<li><a href="">天猫</a></li>
				<li><a href="">聚划算</a></li>
				<li><a href="">全球速卖通</a></li>
				<li><a href="">阿里巴巴国际交易市场</a></li>
				<li><a href="">1688</a></li>
				<li><a href="">阿里妈妈</a></li>
				<li><a href="">阿里旅行</a></li>
				<li><a href="">阿里云计算</a></li>
				<li><a href="">阿里巴巴集团</a></li>
				<li><a href="">淘宝网</a></li>
				<li><a href="">天猫</a></li>
				<li><a href="">聚划算</a></li>
				<li><a href="">全球速卖通</a></li>
				<li><a href="">阿里巴巴国际交易市场</a></li>
				<li><a href="">1688</a></li>
				<li><a href="">阿里妈妈</a></li>
				<li><a href="">阿里云计算</a></li>
			</ul>
		</div>
		<div class="footer-bd">

			<a href=" ">关于淘宝</a> <a href=" ">合作伙伴</a> <a href=" ">营销中心</a> <a
				href=" ">廉正举报</a> <a href=" ">联系客服</a> <a href=" ">开放平台</a> <a
				href=" ">诚征英才</a> <a href=" ">联系我们</a> <a href=" ">网站地图</a> <a
				href=" ">法律声明</a> <em>© 2003-2015 Taobao.com 版权所有</em><br> <br>
			<span>网络文化经营许可证：<a href=" ">浙网文[2013]0268-027号</a> </span> <b>|</b> <span
				data-spm-protocol="i">增值电信业务经营许可证：<a href="">浙B2-20080224-1</a>
			</span> <b>|</b> <span>信息网络传播视听节目许可证：1109364号</span> <b>|</b> <span>举报电话:0571-81683755</span>
		</div>
	</div>
</body>
</html>
<!-- <script >
	/* function checkMail(str) {
		var strReg = "";
		var r;
		var strText = document.all(str).value;
		//strReg=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/i;
		strReg = /^\w+((-\w+)|(\.\w+))*\@{1}\w+\.{1}\w{2,4}(\.{0,1}\w{2}){0,1}/ig;
		r = strText.search(strReg);
		if (r == -1) {
			alert("邮箱格式错误!");
			document.all(str).focus();
		}
	} */
	
	$(function(){
	$("#email").change(function(){
	var name=$("#email").val();	
	//验证邮箱格式
	var email= /^\w+((-\w+)|(\.\w+))*\@{1}\w+\.{1}\w{2,4}(\.{0,1}\w{2}){0,1}/ig;
	var phone=/^1[3456789]\d{9}$/;
	if(!email.test(name)){
	alert("邮箱格式错误!");
	}
	
	if(email.test(name)){
	$(".yanzheng").attr("disabled","disabled");
	$("#button").attr("disabled","disabled");
	
	//判断用户的操作
	$("uname").change(function(){
	var name1=$("#uname").val();
	$.get("user/toAjax",{
	name:name1
	},function(data){
	if(data==name1){
	alert("用户名已经存在");
	}
	//alert("返回值:"+data);
	});
	})
	}
	
	})
	})	
</script> -->
<script >
//判断邮箱是否是合法的邮箱
/* $(function(){
  $("#email").change(function(){
    var name = $("#email").val();
    //alert(name);
     
     //如果邮箱格式正确 去除下面的验证码
   var  email =/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/; //邮箱正则表达式
   var  phone = /^1[3456789]\d{9}$/;//手机正则表达式
     if(!email.test(name)){
       alert("请输入正确的email,手机号登录请忽略");
     }
     if(email.test(name)){
      //正确的话
      $(".yanzheng").attr("disabled","disabled");
      $("#button").attr("disabled","disabled");
      //使用ajax判断用户是否存在
      $("#uname").change(function() {
			//取用户输入的用户名
			var name1 = $("#uname").val();
			//alert(name1)
			$.get("/crowdfunding/user/toAjax", {
				name : name1
			}, function(data) {
				if(data!=""){
				  //相等表示 数据库中已经有数据了 不能再注册了
				  alert("用户名已经存在!请重新输入")
				}
			});
			
		});
     }
     
  })
}) */

/* $(function(){
   $("#button").click(function(){
      var a=$("#email").val();
       $.ajax({
       url:"/crowdfunding/user/duan",
       type="get",
       dataType="json",
       data:{a},
       success:function(data){
       if(data.code==0){
       alert("发送成功");
       }else{
       alert("发送失败");
       }       
       }
       })
   })
}) */
   function sendMessage(){
   $.ajax({
   url:"/crowdfunding/user/getCode",
   data:"tel="+$("#email").val()
       /* success:function(data){
       if(data.code==0){
       alert("发送成功");
       }else{
       alert("发送失败");
       }       
       } */
   })
       //alert($("#email").val())
       
     
   }
</script>
