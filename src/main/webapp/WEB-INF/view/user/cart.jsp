<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/cart.css"/>
    
</head>

<body>
	<jsp:include page="/includes/header.jsp"></jsp:include>
    <div class="__cart-container">
        <div class="__cart-header">
            <h1 class="f-raleway">
                Shopping Cart
            </h1>
        </div>
        <c:forEach var="products" items="${inCart}" varStatus="loop"> 
        <div class="__cart-body">
            <div class="__cart-item">
				<div>${loop.index + 1}</div>
                <img src="<%=request.getContextPath()%>/uploads/product_images/<c:out value="${products.image}"></c:out>">
                <div>${products.modelNo}</div>
                <div>${products.title}</div>
                <div>
                    <label>QTY</label>
                    <input type="number" min="1" max="10" value="1">
                </div>
                <div>Price: Rs. ${products.discountedPrice}</div>
                <div><a href="${pageContext.request.contextPath}/user/cart?product_ID=${products.id}" style="color: #ff4052">Delete Items</a></div>
                
            </div>
        </div>
        </c:forEach>
        <div class="__cart-footer">
            <div class="__cart-total">
                Total: Rs.12,399
            </div>
            <button>Confirm Order</button>
        </div>
    </div>
    
</body>

</html>