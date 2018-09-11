<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" type="text/css"/>
    <link href="${pageContext.request.contextPath }/css/reg.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/base.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/headbott.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/ly-list.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/reg.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/detail.css" type="text/css"/>
    <title>Title</title>
</head>
<body>
<div id="header">
    <div class="heade-con">
        <div class="logo"><a href=""><img src="${pageContext.request.contextPath }/images/LOGO.png"/></a></div>
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
                <input type="text" class="search-txt" value="" placeholder="找项目">
                <input type="submit" class="search-but" value="">
            </form>
        </div>
        <div class="index-login">

            <c:if test="${user!=null }">
            <a href="/crowdfunding/user/to_user?uName=${user.getuName() }">个人中心</a>
            <span style="color: white;">|</span>
            <a href="/crowdfunding/zhuan/out">退出</a>
            </c:if>
        	<c:if test="${user==null }">
            <a href="/crowdfunding/zhuan/userLogin">登录</a> 
            <span style="color: white;">|</span>
            <a href="/crowdfunding/zhuan/reg">注册</a>   
            </c:if>
        </div>
    </div>
</div>
<!--中间-->
<div class="product">
    <!--头上表格-->
    <div class="product-table">
        <div class="product-left">
            <table class="table table-bordered">
                <tr class="text-center">
                    <td class="title-td"><a href="/crowdfunding/zhuan/to_new_product">基本信息</a></td>
                    <td class="active title-td"><a href="/crowdfunding/zhuan/to_new_info">项目信息</a></td>
                    <td class="title-td"><a href="/crowdfunding/zhuan/to_new_detail">详细描述</a></td>
                    <td class="title-td"><a href="/crowdfunding/zhuan/to_new_back">回报设置</a></td>
                </tr>
            </table>
        </div>
        <div class="product-right">
            <table class="table table-bordered">
                <tr class="text-center">
                    <td class="title-td">预览</td>
                </tr>

            </table>

        </div>
    </div>
    <!--下部foem表单-->
    <div class="product-form">
        <!--上标题-->
        <div class="product-title">
            <div class="my-h4">
                <h4>描述你的项目详情</h4>
            </div>
            <div class="btn-save">
                <button onclick="doAdd()" class="btn btn-default">保存草稿</button>
            </div>

        </div>
        <div class="clear"></div>
        <hr>
        <!--表单-->
        <!--宣传视频-->
        <!-- <div>
            <form >
            </form>
        </div> -->
        <div class="clear"></div>
        <hr>
        <!--编辑信息表单-->
        <form name="form" action="/crowdfunding/Initiator/addProDesc">
            <div class="my-form">
                <div class="detail"><b>宣传视频：</b><input name="dView" class="detail-input" placeholder="填写视频在线播放地址"></div>
                <div class="detail"><b>项目故事：</b><div><textarea name="dStory" rows="2" placeholder="填写项目故事"></textarea></div></div>
                <div class="detail"><b>更多支持：</b><div><textarea name="dSupport" rows="2" placeholder="支持"></textarea></div></div>
                <div class="detail"><b>提供回报：</b><div><textarea name="" rows="2" placeholder="回报"></textarea></div></div>
                <div class="detail"><b>关于我：</b><div><textarea name="dInfo" rows="2" placeholder="关于我的信息"></textarea></div></div>
            </div>
        </form>
    </div>
</div>
<!--下部-->
<div id="bottom">
    <div class="bottom-ggt"><a href=""><img src="${pageContext.request.contextPath }/images/bottbom_68.jpg" alt=""/></a></div>
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

        <a href=" ">关于淘宝</a>
        <a href=" ">合作伙伴</a>
        <a href=" ">营销中心</a>
        <a href=" ">廉正举报</a>
        <a href=" ">联系客服</a>
        <a href=" ">开放平台</a>
        <a href=" ">诚征英才</a>
        <a href=" ">联系我们</a>
        <a href=" ">网站地图</a>
        <a href=" ">法律声明</a>　　　
        <em>© 2003-2015 Taobao.com 版权所有</em><br>

        <br>
        <span>网络文化经营许可证：<a href=" ">浙网文[2013]0268-027号</a></span>
        <b>|</b>
        <span data-spm-protocol="i">增值电信业务经营许可证：<a href="">浙B2-20080224-1</a></span>
        <b>|</b>
        <span>信息网络传播视听节目许可证：1109364号</span>
        <b>|</b>
        <span>举报电话:0571-81683755</span>
    </div>
</div>
</body>
</html>
<script>
     function doAdd(){   
         //alert("进来了");
         document.getElementsByName("form")[0].submit();
        /*  window.location.href="/crowdfunding/Initiator/addInitiator"; */   
   } 
</script>