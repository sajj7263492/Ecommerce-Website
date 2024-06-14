<%@page import="model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Date"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Home page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/view/CSS/Homepage.css" />
 
</head>
<body>

	<c:set var="time" value="<%=new Date().getTime()%>" />
	<div class="home">
		<nav>

			<div class="menu">
				<div class="logo">
					<img src="${pageContext.request.contextPath}/images/homepage-images/ESBA.png"
						style="height: 40px; width: 90px" alt="" />
				</div>
				<div class="logo search-div">
					<div class="input-group">
						<input type="text" class="input" name="search"
							placeholder="Search" /> <input class="button--submit"
							value="Search" type="submit" />
					</div>
				</div>
				<div class="home">
					<div>
						<ul style="margin-top: 10px">
							<li><a
								style="font-size: 23px; background-color: white; color: black;"
								href="${pageContext.request.contextPath}/homepage">Home</a></li>
							<c:if
								test="${sessionScope.isLoggedIn == true && sessionScope.isLoggedIn!= null}">
								<li><a style="font-size: 23px"
									href="${pageContext.request.contextPath}/viewCart">View
										Cart</a></li>
							</c:if>
						</ul>
					</div>
					<c:if
						test="${sessionScope.isLoggedIn == true && sessionScope.isLoggedIn!= null}">
						<c:set var="userDao" value="<%=new UserDAO()%>" />
						<c:set var="userDetails"
							value="${userDao.fetchUserDetails(sessionScope.loggedId)}" />
						<div style="margin-left: 30px">
							<img class="user-img" onclick="toggleDropdown();"
								src="${pageContext.request.contextPath}/images/${userDetails.photoPath}?v=${time}"
								alt="" />
							<div class="click-img" id="dropdown">
								<a href="${pageContext.request.contextPath}/editProfile">Edit Profile</a> <a href="${pageContext.request.contextPath}/viewProfile">View Profile</a> <a
									href="${pageContext.request.contextPath}/logout">Logout</a>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</nav>

		<div class="background-img"></div>
		<div class="center">
			<div class="title">We Bring The Good Cart To Life.</div>
			<div class="sub_title">Shop Now</div>
			<c:if
				test="${sessionScope.isLoggedIn != true && sessionScope.isLoggedIn== null}">
				<div class="btns">
					<a href="${pageContext.request.contextPath}/view/JSP/UserLogin.jsp"><button class="signin">SIGN IN</button></a>
					<a href="${pageContext.request.contextPath}/view/JSP/UserRegistration.jsp"><button class="signup">SIGN
							UP</button></a>
				</div>
			</c:if>
		</div>
	</div>


	<div class="products">
		<h1 class="product-heading">Products</h1>
		
    
		<div class="product-list">
			<c:forEach var="product" items="${productList}">
				<div class="box">
					<div class="card">
						<img
							src="${pageContext.request.contextPath}/images/${product.productImage}?v=${time}"
							alt="Denim Jeans" style="width: 260px; height: 260px;" />
						<h2>${product.productName}</h2>
						<p class="price">Rs.${product.productPrice}</p>
						<p class="brand">${product.productBrand}</p>
						
						<p>
							<button type="submit" 
								onclick="location.href='${pageContext.request.contextPath}/addToCart?productId=${product.productId}'">Add
								to Cart</button>
						</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<script>
		function toggleDropdown() {
			var dropdown = document.getElementById("dropdown");
			dropdown.style.display = dropdown.style.display === "none" ? "block"
					: "none";
		}
	</script>
</body>
</html>



