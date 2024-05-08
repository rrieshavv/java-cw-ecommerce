<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/product-desc.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
    
    

</head>
<body>

	    <div class="__detail-main">
        <div class="__detail-image-side">
            <div class="__thumbnail-image">
                <img src="${pageContext.request.contextPath}/uploads/product_images/${productDetail.image}" width="300" height="300" />
            </div>
        </div>
        <div class="__detail-desc-side">
            <div class="__detail-desc-header">
                <p class="__desc-new">New</p>
                <p class="__desc-model"></p>
                <p class="__desc-title">${productDetail.title}</p>
                <hr>
            </div>
            <div class="__detail-desc-body">
                <div class="__detail-text">
                <ul>
                	<li>
                		<p>Model number ${productDetail.modelNo}</p>
                	</li>
                	<li>
                		<p>${productDetail.description}</p>
                	</li>
                	<li>
                		<p>Made by ${productDetail.brand}</p>
                	</li>
                	
                	
                </ul>
                  
                </div>
                <div class="__pricing">
                    <p class="__pricing-text">
                        <span class="__text-danger">
                            <strike>Rs. ${productDetail.actualPrice}</strike>
                        </span>
                        <span>
                            Rs. ${productDetail.discountedPrice} /-
                        </span>
                    </p>
                </div>
                <div class="__add-cart-form">
                    <form method="post">
                        <input placeholder="Qty" class="__qty-input" type="number" min="1" max="${productDetail.quantity}" value="1" />
                        <button class="__btn __btn-success __add-to-card-btn">Add to cart</button>
                    </form>
                </div>
                <br>
				<p>Avaliable Stock  <strong style="color:black; font-weight: 800" >${productDetail.quantity}</strong></p>
            </div>
        </div>
    </div>
    <footer>
        <div class="__footer-header">
        </div>
        <div class="__footer-title">
            GIGA CCTV STORE
        </div>
        <div class="__footer-section">

            <div class="__footer-contact">
                <div>
                    <img src="../assets/icons/location.png" />
                    <p>Kamalpokhari, Kathmandu</p>
                </div>
                <div>
                    <img src="../assets/icons/email.png" />
                    <p>+123-456-789</p>
                </div>
                <div>
                    <img src="../assets/icons/phone-call.png" />
                    <p>info@giga.com.np</p>
                </div>
            </div>

            <div class="__footer-newsletter">
                <div>
                    Remain Updated
                </div>
                <div class="__footer-newsletter-input">
                    <input placeholder="Email Address" type="email" />
                    <button class="__btn __btn-orange">Sign Up</button>
                </div>
            </div>
        </div>
    </footer>


</body>
</html>