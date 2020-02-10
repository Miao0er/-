<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid"%>
<!-- 主页模板页 2019/7/10 刘硕 -->
<!DOCTYPE html>
<html>
<rapid:block name="basehead">
	<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Reset.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/app.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/stylelist.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/MainStyle.css">


	</head>
</rapid:block>
<body class="grayback">
	<rapid:block name="pageheader">
		<nav class="header-nav" role="navigation">
			<div class="header-container">
				<div class="row">
					<div class="col-sm-4 col-xs-12">
						<div id="header-logo">

							<a href="${pageContext.request.contextPath }/"> <img
								id="logoimg"
								src="${pageContext.request.contextPath}/resources/image/logo.png" /></a>
						</div>
					</div>
					<div class="col-xs-8 text-right" id="menu-header-right">
						<ul>
							<li class="btn-cta"><a
								href="${pageContext.request.contextPath }/login" id="loginbtn">2019-06-17
									星期一 15：02</a></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	</rapid:block>
	<rapid:block name="pageleft">
		<div class="left-side-bar .side-fixed">
			<div class="left-person-info">
				<div class="person-head">
					<img id="headimg"
						src="${pageContext.request.contextPath}/resources/headimage/${username}/${userhead}" />
				</div>
				<div class="person-btn">
					<p>余倩</p>
					<div class="person-btn-icons">
						<a><img class="person-btn-icon"
							src="${pageContext.request.contextPath}/resources/image/个人信息设置按钮.png" /></a>
						<a><img class="person-btn-icon"
							src="${pageContext.request.contextPath}/resources/image/个人信息注销按钮.png" /></a>
					</div>
				</div>
			</div>
			<div class="left-bar-list">
				<nav class="drawer-main">
					<ul class="nav nav-drawer">
						<li class="nav-item"><a href="index.html"><img
								class="left-list-icon"
								src="${pageContext.request.contextPath}/resources/image/lefticon1.png" /></i>
								我的待办任务</a></li>

						<li class="nav-item"><a href="frontend_home.html"><img
								class="left-list-icon"
								src="${pageContext.request.contextPath}/resources/image/lefticon2.png" />我的已办任务</a>
						</li>
						<li class="nav-item"><a href="frontend_home.html"><img
								class="left-list-icon"
								src="${pageContext.request.contextPath}/resources/image/lefticon2.png" />提醒消息</a>
						</li>
						<li class="nav-item"><a href="frontend_home.html"><img
								class="left-list-icon"
								src="${pageContext.request.contextPath}/resources/image/lefticon3.png" />我的周报</a>
						</li>
						<li class="nav-item"><a href="frontend_home.html"><img
								class="left-list-icon"
								src="${pageContext.request.contextPath}/resources/image/lefticon4.png" />我的日志</a>
						</li>
						<li class="nav-item"><a href="frontend_home.html"><img
								class="left-list-icon"
								src="${pageContext.request.contextPath}/resources/image/lefticon5.png" />我的项目</a>
						</li>
						<li class="nav-item"><a href="frontend_home.html"><img
								class="left-list-icon"
								src="${pageContext.request.contextPath}/resources/image/lefticon6.png" />我的查封资产</a>
						</li>
					</ul>
				</nav>
			</div>
		</div>
	</rapid:block>
	<rapid:block name="pagemiddle">
		<div class="middle-main">
			
		</div>
	</rapid:block>
	<rapid:block name="pageright">
		<div class="right-side-bar .side-fixed">
			<div class="right-top-bar">
				<div class="right-top-header">
					<img class="left-list-icon"
						src="${pageContext.request.contextPath}/resources/image/righttopheadericon.png" />
					我的应用
				</div>
				<a class="card" href="javascript:void(0)">
					<div class="text-center">
						<img class="button-img"
							src="${pageContext.request.contextPath}/resources/image/topbutton11.png"
							alt="">
						<p>客户管理</p>
					</div>
				</a> <a class="card" href="javascript:void(0)">
					<div class="text-center">
						<img class="button-img"
							src="${pageContext.request.contextPath}/resources/image/topbutton10.png"
							alt="">
						<p>项目管理</p>
					</div>
				</a> <a class="card" href="javascript:void(0)">
					<div class="text-center">
						<img class="button-img"
							src="${pageContext.request.contextPath}/resources/image/topbutton9.png"
							alt="">
						<p>用户管理</p>
					</div>
				</a> <a class="card" href="javascript:void(0)">
					<div class="text-center">
						<img class="button-img"
							src="${pageContext.request.contextPath}/resources/image/topbutton8.png"
							alt="">
						<p>团队周报</p>
					</div>
				</a> <a class="card" href="javascript:void(0)">
					<div class="text-center">
						<img class="button-img"
							src="${pageContext.request.contextPath}/resources/image/topbutton7.png"
							alt="">
						<p>公司周报</p>
					</div>
				</a> <a class="card" href="javascript:void(0)">
					<div class="text-center">
						<img class="button-img"
							src="${pageContext.request.contextPath}/resources/image/topbutton6.png"
							alt="">
						<p>团队项目</p>
					</div>
				</a> <a class="card" href="javascript:void(0)">
					<div class="text-center">
						<img class="button-img"
							src="${pageContext.request.contextPath}/resources/image/topbutton5.png"
							alt="">
						<p>公司项目</p>
					</div>
				</a> <a class="card" href="javascript:void(0)">
					<div class="text-center">
						<img class="button-img"
							src="${pageContext.request.contextPath}/resources/image/topbutton4.png"
							alt="">
						<p>团队查封资产项目</p>
					</div>
				</a> <a class="card" href="javascript:void(0)">
					<div class="text-center">
						<img class="button-img"
							src="${pageContext.request.contextPath}/resources/image/topbutton3.png"
							alt="">
						<p>公司查封资产项目</p>
					</div>
				</a> <a class="card" href="javascript:void(0)">
					<div class="text-center">
						<img class="button-img"
							src="${pageContext.request.contextPath}/resources/image/topbutton2.png"
							alt="">
						<p>统计</p>
					</div>
				</a> <a class="card" href="javascript:void(0)">
					<div class="text-center">
						<img class="button-img"
							src="${pageContext.request.contextPath}/resources/image/topbutton1.png"
							alt="">
						<p>通讯录</p>
					</div>
				</a> <a class="card" href="javascript:void(0)"> </a>
			</div>
			<div class="right-side-new">
				<div class="right-new-header">
					<img class="left-list-icon"
						src="${pageContext.request.contextPath}/resources/image/rightbottomheadericon.png" />
					公告
				</div>
				<div>
					<ul>
						<li><span class="brief-new">针对办公文案规范范文公告</span><span
							class="new-time">2019-06-17</span></li>
						<li><span class="brief-new">针对办公文案规范范文公告</span><span
							class="new-time">2019-06-17</span></li>
						<li><span class="brief-new">针对办公文案规范范文公告</span><span
							class="new-time">2019-06-17</span></li>
						<li><span class="brief-new">针对办公文案规范范文公告</span><span
							class="new-time">2019-06-17</span></li>
						<li><span class="brief-new">针对办公文案规范范文公告</span><span
							class="new-time">2019-06-17</span></li>
					</ul>
				</div>
			</div>
		</div>
	</rapid:block>
	<rapid:block name="alertpage">
		<!-- 弹出的添加信息框 -->
		<div id="add-form" class="modal fade" tabindex="-1" role="dialog">
		
		</div>
	</rapid:block>
	<rapid:block name="pagejs">
		<script
			src="${pageContext.request.contextPath}/resources/js/core/jquery.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/js/core/bootstrap.min.js"></script>
	</rapid:block>
</body>
</html>