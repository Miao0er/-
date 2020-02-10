<!-- 登录页 2019/7/7 刘硕 -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
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
	href="${pageContext.request.contextPath}/resources/css/loginStyle.css">
</head>
<body>
	<div id="loginback">
		<div class="loginpagecontainer">
			<div id="logo"></div>
			<div id="logincontainer">
				<div class="tab-content">
					<div class="tab-content-inner active" data-content="login">
						<form:form method="POST" action="${pageContext.request.contextPath}/login">
							<div class="row form-group">
								<div class="col-md-12">
									<label for="username">账号</label>
									<input class="textbox" name="username" id="lusername">
								</div>
							</div>
							<div class="row form-group">
								<div class="col-md-12">
									<label for="password">密码</label> 
									<input type="password" class="textbox" name="password" id="lpassword">
								</div>
							</div>
							<div class="row form-group check-input">
								<div class="col-md-12">
									<input type="checkbox" name="remember" /> <span
										class="default" id="spasswordErr">记住用户名及密码</span>
								</div>
							</div>
							<div class="row form-group">
								<div class="col-md-12">
									<input type="submit" class="btn btn-primary login-btn"
										value="登录">
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>