<%@page import="model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="ErrorHandler.jsp"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>User Profile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/CSS/ViewProfile.css" />
  </head>
  <body>
  	<c:set var="time" value="<%=new Date().getTime()%>"/>
    <!-- navbar end -->
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
								style="font-size: 23px;"
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
								<a href="${pageContext.request.contextPath}/editProfile">Edit Profile</a>
								 <a href="${pageContext.request.contextPath}/viewProfile">View Profile</a> 
								 <a href="${pageContext.request.contextPath}/logout">Logout</a>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</nav>
    </div>

    <!-- navbar start -->
    <div class="container">
    <h3 style="color:green; text-align:center;"> <c:out value="${sessionScope.profileUpdateStatus}" /></h3>
        <%session.removeAttribute("profileUpdateStatus"); %>
      <div class="user-details">
        <div class="user-image">
          <img class="image" src="${pageContext.request.contextPath}/images/${user.photoPath}?v=${time}" alt="" />
        </div>
        <h2>${user.fullName }</h2>
        <h3>${user.email}</h3>
        <p>${user.gender }</p>
        <p>${user.address }</p>
        <p>${user.phoneNum }</p>
      </div>
    </div>
    <script>
      function toggleDropdown() {
        var dropdown = document.getElementById("dropdown");
        dropdown.style.display =
          dropdown.style.display === "none" ? "block" : "none";
      }
    </script>
  </body>
</html>
