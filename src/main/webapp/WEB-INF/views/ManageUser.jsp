<!-- 角色管理页 2019/7/8 刘硕 -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="Userinfo" class="nju.sofware.data.dataobject.Userinfo"
	scope="request"></jsp:useBean>
<rapid:override name="pagemiddle">
	<div class="middle-main">
		<div class="middle-list">
			<div class="middle-header">
				<div class="middle-header-content">
					<img class="left-list-icon"
						src="${pageContext.request.contextPath}/resources/image/middletopheadericon.png" />
					角色管理
				</div>

			</div>
			<div class="middle-main-actions">
				<div class="left-actions">
					<ul>
						<li><a href="${pageContext.request.contextPath }/teammember/teammemberpage">成员管理</a></li>
						<li><a href="${pageContext.request.contextPath }/team/teampage">团队管理</a></li>
						<li class="chosen"><a href="${pageContext.request.contextPath }/user/userinfoPage">角色管理</a></li>
					</ul>
				</div>
				<div class="right-actions">
					<input type="submit" class="btn btn-primary middle-main-btn"
						value="新增用户" data-toggle="modal" data-target="#add-form">
				</div>
			</div>
			<div class="card-block">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th class="text-center" style="width: 50px;">序号</th>
							<th class="table-th-name">用户名</th>
							<th class="table-th-name">姓名</th>
							<th class="table-th-phone">角色</th>
							<th class="table-th-email">模块</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						
							<c:forEach items="${userinfos}" var="userinfo">
							
							<tr>
							<form:form id="oneuserinfo" name="oneuserinfo" method="POST" action="${pageContext.request.contextPath }/user/updateUserinfo" commandName="Userinfo">
								<td><input name="id" value="${userinfo.id}" readonly="readonly"></td>
								<td><input name="username" value="${userinfo.username}"></td>
								<td><input name="name" value="${userinfo.name}"></td>
								<td><input name="role" value="${userinfo.role}"></td>
								<td><input name="mode" value="${userinfo.mode}"></td>
								<td class="text-center">
									<div class="btn-group"> 
									<button type="submit"><img
											src="${pageContext.request.contextPath}/resources/image/pencil.png" /></button>
										<a href="${pageContext.request.contextPath }/user/deleteUserinfo?infoid=${userinfo.id}"><img
											src="${pageContext.request.contextPath}/resources/image/delete.png" /></a>
									</div>
								</td>
								</tr>
								</form:form>
							</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</rapid:override>

<rapid:override name="alertpage">
	<div id="add-form" class="modal fade" tabindex="-1" role="dialog">
		<div class="card modal-dialog modal-dialog-top">
			<div class="card-header bg-teal bg-inverse">
				<h4>添加用户</h4>
			</div>
			<div class="card-block" style="overflow: auto; max-height: 600px;">
				<form:form name="userinfoForm" method="POST" action="${pageContext.request.contextPath }/user/addUserinfo" commandName="Userinfo">
					<div class="form-group">
						<div class="col-xs-6">
							<label for="username">用户名</label> 
							<input class="form-control" type="text" id="username" name="username" placeholder="用户名">
						</div>
						<div class="col-xs-6">
							<label for="name">姓名</label> 
							<input class="form-control" type="text" id="name" name="name" placeholder="姓名">
						</div>
						<div class="col-xs-6">
							<label for="role">角色</label> 
							<input class="form-control" type="text" id="role" name="role" placeholder="角色">
						</div>
						<div class="col-xs-6">
							<label for="mode">可控模块</label> 
							<input class="form-control" type="text" id="mode" name="mode" placeholder="可控模块">
						</div>
						<div class="col-xs-6">
							<label for="headimage">头像路径</label> 
							<input class="form-control" type="text" id="headimage" name="headimage" placeholder="头像路径">
						</div>
						<div class="form-group m-b-0">
						<div class="col-xs-12">
							<button class="btn btn-app-teal" type="submit">提交信息</button>
						</div>
					</div>
				</form:form>
				
			</div>
			<!-- .card-block -->
		</div>
	</div>
</rapid:override>
<%@ include file="MainTemplate.jsp"%>