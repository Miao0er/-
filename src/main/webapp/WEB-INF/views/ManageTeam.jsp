<!-- 团队管理页 2019/7/10 刘硕 -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="Teaminfo" class="nju.sofware.data.dataobject.Teaminfo"
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
						<li class="chosen"><a href="${pageContext.request.contextPath }/team/teampage">团队管理</a></li>
						<li><a href="${pageContext.request.contextPath }/user/userinfoPage">角色管理</a></li>
					</ul>
				</div>
				<div class="right-actions">
					<input type="submit" class="btn btn-primary middle-main-btn"
						value="新增团队" data-toggle="modal" data-target="#add-form">
				</div>
			</div>
			<div class="card-block">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th class="text-center" style="width: 50px;">序号</th>
							<th class="table-th-name">负责人</th>
							<th class="table-th-name">团队名</th>
							<th class="table-th-phone">联系方式</th>
							<th class="table-th-email">电子邮箱</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						
							<c:forEach items="${teaminfos}" var="teaminfo">
							
							<tr>
							<form:form name="oneteaminfo" method="POST" action="${pageContext.request.contextPath }/team/updateteaminfo" commandName="Teaminfo">
								<td><input name="id" value="${teaminfo.id}" readonly="readonly"></td>
								<td><input name="teamname" value="${teaminfo.leadername}"></td>
								<td><input name="leadername" value="${teaminfo.teamname}"></td>
								<td><input name="leaderphone" value="${teaminfo.leaderphone}"></td>
								<td><input name="leaderemail" value="${teaminfo.leaderemail}"></td>
								<td class="text-center">
									<div class="btn-group">
									
									<button type="submit"><img
											src="${pageContext.request.contextPath}/resources/image/pencil.png" /></button>
										<a href="${pageContext.request.contextPath }/team/deleteteaminfo?infoid=${teaminfo.id}"><img
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
				<h4>添加团队</h4>
			</div>
			<div class="card-block" style="overflow: auto; max-height: 600px;">
				<form:form name="teaminfoForm" method="POST" action="${pageContext.request.contextPath }/team/addteaminfo" commandName="Teaminfo">
					<div class="form-group">
						<div class="col-xs-6">
							<label for="teamname">团队名</label>
							<input class="form-control" type="text" id="teamname" name="teamname" placeholder="团队名">
						</div>
						<div class="col-xs-6">
							<label for="leadername">领导名</label>
							<input class="form-control" type="text" id="leadername" name="leadername" placeholder="领导名">
						</div>
						<div class="col-xs-6">
							<label for="leaderphone">领导电话</label>
							<input class="form-control" type="text" id="leaderphone" name="leaderphone" placeholder="领导电话">
						</div>
						<div class="col-xs-6">
							<label for="leaderemail">可控模块</label>
							<input class="form-control" type="text" id="leaderemail" name="leaderemail" placeholder="领导邮件">
						</div>
						<%--<div class="col-xs-6">--%>
							<%--<label for="headimage">头像路径</label> --%>
							<%--<input class="form-control" type="text" id="headimage" name="headimage" placeholder="头像路径">--%>
						<%--</div>--%>
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