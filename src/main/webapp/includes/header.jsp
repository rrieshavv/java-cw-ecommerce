<%@page import="model.User"%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/navbar.css"/>
<nav>
        <div class="icon">
            <img src="${pageContext.request.contextPath}/assets/logo/logomain2.png"  alt="GigaCctv Logo" class="logo-main">
        </div>
        <div class="search_box">
        <form id="searchForm" action="/Cctv/Home" method="get">
        		<input type="search" name="search_product" placeholder="Search here"></input>
        		<span class="fa fa-search" onclick="submitForm()"></span>
        </form>
           
           
        </div>
        <ol>
             <li><a href="<%= request.getContextPath() %>/home">Home</a></li>
            <li><a href="<%= request.getContextPath() %>/home">View Products</a></li>
             <li><a href="User">User</a></li>
            <li><a href="<%= request.getContextPath() %>/about-us">About us</a></li>
              <%
            	if((User)session.getAttribute("user") == null){
            	%>
                    <li><a href="<%= request.getContextPath() %>/login">Login here</a></li>
            	<%}
            	else{
            	%>
                    <li><a href="<%= request.getContextPath() %>/logout">Logout here</a></li>
            	<%}
            
            %>
            
        </ol>
    </nav>