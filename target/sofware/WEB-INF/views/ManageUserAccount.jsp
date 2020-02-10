<!-- 用户管理页 2019/7/8 刘硕 -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="Useraccount" class="nju.sofware.service.model.UserAccountModel"
	scope="request"></jsp:useBean>
<rapid:override name="pagemiddle">
	<div class="middle-main">
		<div class="middle-list">
			<div class="middle-header">
				<div class="middle-header-content">
					<img class="left-list-icon" src="../image/middletopheadericon.png" />
					个人信息
				</div>
			</div>
			<div class="middle-form">
				<form name="detailForm" method="POST" enctype="multipart/form-data" action="${pageContext.request.contextPath }/user/updateuseraccount" commandName="Useraccount"><!-- commandName="Useraccount" -->
					<div>
						<div class="form-line">
							<label for="headpicpath">头像修改</label> <input id="upload"
								name="upload" accept="image/*" type="file"
								style="visible: hidden; display: none" /> <input
								class="form-control" type="text" id="headpicpath"
								name="headpicpath" value="${useraccount.headimage}" placeholder="请选择上传路径"> <img id="picb"
								src="../image/uploadbtn.png" class="file-upload-input" />
						</div>
						<div class="form-line">
							<label for="password">密码修改</label> <input class="form-control"
								type="text" id="password" name="password" placeholder="请输入新的密码">
						</div>
						<div class="form-line">
							<label for="repassword"></label> <input class="form-control"
								type="text" id="repassword" name="repassword" 
								placeholder="请再次输入新的密码">
						</div>
						<div class="form-line">
							<label for="phone">手机号码</label> <input class="form-control"
								type="text" id="phone" name="phone" value=" ${useraccount.phone}" placeholder="请输入新的手机号码">
						</div>
						<div class="form-line">
							<label for="email">电子邮箱</label> <input class="form-control"
								type="text" id="email" name="email" value=" ${useraccount.email}" placeholder="请输入新的电子邮箱">
						</div>
					</div>
					<div class="form-line">
						<div class="form-line-btn">
							<button class="btn btn-app-teal" type="submit">提交</button>
						</div>
					</div>
				</form>
			</div>
			<div class="card-block"></div>
		</div>
	</div>
</rapid:override>
<rapid:override name="pagejs">
	
	<script
		src="${pageContext.request.contextPath}/resources/js/core/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/core/bootstrap.min.js"></script>
		<script
		src="${pageContext.request.contextPath}/resources/js/upheadimage.js"></script>
</rapid:override>
<%@ include file="MainTemplate.jsp"%>