<%@page import="model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Cart</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/view/CSS/ViewCart.css" />
</head>
<body>
<c:set var="time" value="<%=new Date().getTime()%>"/>
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
							<li><a style="font-size: 23px;"
								href="${pageContext.request.contextPath}/homepage">Home</a></li>
							<c:if
								test="${sessionScope.isLoggedIn == true && sessionScope.isLoggedIn!= null}">
								<li><a
									style="font-size: 23px; background-color: white; color: black;">View
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
	</div>


	<div class="view-cart-dtls">

		<h1 class="cart-heading">Your Cart</h1>
		<div class="cart-items">
			<table>
				<tr>
					<th><h3>Items</h3></th>
					<th><h3>Brand</h3></th>
					<th><h3>Price</h3></th>
					<th><h3>Action</h3></th>
				</tr>
				
				
					<c:if test="${not empty orderStatus}">
        <div class="alert">
            ${msg}
            <span class="close-btn" onclick="this.parentElement.style.display='none';">&times;</span>
        </div>
    </c:if>
    <% session.removeAttribute("orderStatus"); %>

				<c:forEach var='cart' items="${sessionScope.cartItems}">
					<tr>
						<td>
							<div class="items"></div> <img class="view-cart-img"
							src="${pageContext.request.contextPath}/images/${cart.productImage}?v=${time}"
							alt="" />
							<h4>${cart.productName}</h4>
						</td>
						<td>${cart.productBrand}</td>
						<td>${cart.productPrice}</td>
						<td><a
							href="${pageContext.request.contextPath}/makeOrder?productId=${cart.productId}">
								<button class="Order-Now">Order Now</button>
						</a> <a
							href="${pageContext.request.contextPath}/deleteCartItem?productId=${cart.productId}">
								<button class="Delete">Delete</button>
						</a></td>
					</tr>
				</c:forEach>
			</table>
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