<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard | Admin</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/dashboard.css" />
</head>
<body>
	<div class="__window">
		<div class="__nav">
			<jsp:include page="/includes/nav.jsp"></jsp:include>
		</div>
		<div class="__container">
			<div class="__container-header">
				<div class="__header">Dashboard</div>
			</div>
			<div class="__container-body">
				<h1>Hello, admin!</h1>
				<div class="__row">
					<div class="__box-card">
						<div class="__box-card-body">
							<div>
								<img src="${pageContext.request.contextPath}/assets/icons/products.png" width="60" height="60" />
							</div>
							<div>Total Products: ${totalProducts}</div>
						</div>
						<div class="__box-card-footer">
							<a href="<%= request.getContextPath() %>/admin/product">Go to page</a>
						</div>
					</div>
					<div class="__box-card">
						<div class="__box-card-body">
							<div>
								<img src="${pageContext.request.contextPath}/assets/icons/orders.png" width="60" height="60" />
							</div>
							<div>Total Orders: ${totalOrders}</div>
						</div>
						<div class="__box-card-footer">
							<a href="<%= request.getContextPath() %>/admin/orders">Go to page</a>
						</div>
					</div>
					<div class="__box-card">
						<div class="__box-card-body">
							<div>
								<img src="${pageContext.request.contextPath}/assets/icons/messages.png" width="60" height="60" />
							</div>
							<div>Total Messages: ${totalMessages}</div>
						</div>
						<div class="__box-card-footer">
							<a href="<%= request.getContextPath() %>/admin/messages">Go to page</a>
						</div>
					</div>
				</div>
				<h1 style="margin-top: 2rem;">Track Orders</h1>
				<div class="__row">
					<div class="__box-card">
						<div class="__box-card-body">
							<div>
								<img src="${pageContext.request.contextPath}/assets/icons/pending.png" width="60" height="60" />
							</div>
							<div>Pending: ${totalPending}</div>
						</div>
						<div class="__box-card-footer">
							<a href="<%= request.getContextPath() %>/admin/orders">Go to page</a>
						</div>
					</div>
					<div class="__box-card">
						<div class="__box-card-body">
							<div>
								<img src="${pageContext.request.contextPath}/assets/icons/delivery.png" width="60" height="60" />
							</div>
							<div>Delivered: ${totalDelivered}</div>
						</div>
						<div class="__box-card-footer">
							<a href="<%= request.getContextPath() %>/admin/orders">Go to page</a>
						</div>
					</div>
				</div>
				<h1 style="margin-top: 2rem;">Users</h1>
				<div>
					<table class="__table" style="width: 70%; margin-top: 2rem;">
						<thead>
							<tr>
								<th>Sn.</th>
								<th>UserName</th>
								<th>Email</th>
								<th>Gender</th>
								<th>Joined on</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="counter" value="1" />
							<c:forEach var="user" items="${listofusers}">
								<tr>
									<td><c:out value="${counter}" /></td>
									<td><c:out value="${user.username}"></c:out></td>
									<td><c:out value="${user.email}"></c:out></td>
									<td><c:out value="${user.gender}"></c:out></td>
									<td><c:out value="${user.joinedOn}"></c:out></td>
								</tr>
								<c:set var="counter" value="${counter + 1}" />
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/admin.js"></script>
</body>
</html>