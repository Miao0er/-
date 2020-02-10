<!-- 团队成员页 2019/7/9 刘硕 -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="TeamMember" class="nju.sofware.data.dataobject.TeamMember"
	scope="request"></jsp:useBean>
<rapid:override name="pagemiddle">
	<div class="middle-main">
		<div class="middle-list">
			<div class="middle-header">
				<div class="middle-header-content">
					<img class="left-list-icon"
						src="${pageContext.request.contextPath}/resources/image/middletopheadericon.png" />
					成员管理
				</div>

			</div>
			<div class="middle-main-actions">
				<div class="left-actions">
					<ul>
						<li class="chosen"><a href="${pageContext.request.contextPath }/teammember/teammemberpage">成员管理</a></li>
						<li><a href="${pageContext.request.contextPath }/team/teampage">团队管理</a></li>
						<li><a href="${pageContext.request.contextPath }/user/userinfoPage">角色管理</a></li>
					</ul>
				</div>
			</div>
			<div class="card-block">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th class="text-center" style="width: 50px;">序号</th>
							<th class="table-th-name" style="width: 70px;">用户名</th>
							<th class="table-th-name" style="width: 70px;">姓名</th>
							<th class="table-th-name" style="width: 70px;">性别</th>
							<th class="table-th-name" style="width: 70px;">部门</th>
							<th class="table-th-name" style="width: 70px;">职务</th>
							<th class="table-th-phone" style="width: 120px;">联系方式</th>
							<th class="table-th-email" style="width:160px">电子信箱</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						
							<c:forEach items="${teammembers}" var="teammember">
							
							<tr>
							<form:form name="oneteammember" method="POST" action="${pageContext.request.contextPath }/teammember/updateteammember" commandName="Teammeber">
								<td><input name="id" value="${teammember.id}" readonly="readonly"></td>
								<td><input name="username" value="${teammember.username}"></td>
								<td><input name="name" value="${teammember.name}"></td>
								<td><input name="sex" value="${teammember.sex}"></td>
								<td><input name="teamname" value="${teammember.teamname}"></td>
								<td><input name="teamrole" value="${teammember.teamrole}"></td>
								<td><input name="phone" value="${teammember.phone}"></td>
								<td><input name="email" value="${teammember.email}"></td>
								<td class="text-center">
									<div class="btn-group">
										
									<button type="submit"><img
											src="${pageContext.request.contextPath}/resources/image/pencil.png" /></button>
										<a href="${pageContext.request.contextPath }/teammember/deleteteammember?id=${teammember.id}"><img
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

<%@ include file="MainTemplate.jsp"%>