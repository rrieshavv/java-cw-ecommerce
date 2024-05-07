<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard | Admin</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dashboard.css" />
</head>
<body>
	  <div class="__window">
        <div class="__nav">
        	<jsp:include page="/includes/nav.jsp"></jsp:include>
        </div>
        <div class="__container">
            <div class="__container-header">
                <div class="__header">
                    Dashboard
                </div>
            </div>
            <div class="__container-body">

            </div>
        </div>
    </div>
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/admin.js"></script>
</body>
</html>