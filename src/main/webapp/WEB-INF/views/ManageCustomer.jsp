<!-- 客户管理页 2019/7/10 刘硕 -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:useBean id="Customer" class="nju.sofware.data.dataobject.Ucustomer"
	scope="request"></jsp:useBean>
<rapid:override name="pagemiddle">
	<div class="middle-main">
		<div class="middle-list">
			<div class="middle-header">
				<div class="middle-header-content">
					<img class="left-list-icon"
						src="${pageContext.request.contextPath}/resources/image/middletopheadericon.png" />
					客户管理
				</div>

			</div>
			<div class="middle-main-actions">
				<div class="right-actions">
					<input type="submit" class="btn btn-primary middle-main-btn"
						value="新增客户" data-toggle="modal" data-target="#add-form">
				</div>
			</div>
			<div class="card-block">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th class="text-center" style="width: 10%;">客户号</th>
							<th class="table-th-name" style="width: 30%;">客户名</th>
							<th class="table-th-name" style="width: 30%;">客户全称</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						
							<c:forEach items="${customers}" var="customer">
							
							<tr>
							<form:form id="onecustomer" name="onecustomer" method="POST" action="${pageContext.request.contextPath }/customer/updateCustomer" commandName="Customer">
								<td><input name="customerid" value="${customer.customerid}" readonly="readonly"></td>
								<td><input name="customername" value="${customer.customername}"></td>
								<td><input name="customerfullname" value="${customer.customerfullname}"></td>
								<td class="text-center">
									<div class="btn-group"> 
									<button type="submit"><img
											src="${pageContext.request.contextPath}/resources/image/pencil.png" /></button>
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
				<h4>添加客户</h4>
			</div>
			<div class="card-block" style="overflow: auto; max-height: 600px;">
				<form:form name="userinfoForm" method="POST" action="${pageContext.request.contextPath }/customer/addcustomer" commandName="Userinfo">
					<div class="form-group">
						<div class="col-xs-6">
							<label for="username">客户号</label> 
							<input class="form-control" type="text" id="customerid" name="customerid" placeholder="客户号">
						</div>
						<div class="col-xs-6">
							<label for="name">客户名</label> 
							<input class="form-control" type="text" id="customerbriefname" name="customerbriefname" placeholder="客户名">
						</div>
						<div class="col-xs-6">
							<label for="role">客户全称</label> 
							<input class="form-control" type="text" id="role" name="customerfullname" placeholder="客户全称">
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