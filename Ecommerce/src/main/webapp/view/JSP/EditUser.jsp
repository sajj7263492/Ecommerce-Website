<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Edit Profile</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/view/CSS/UserRegistration.css" />
</head>
<body>
	<div class="body">
	<c:set var="time" value="<%=new Date().getTime()%>"/>
		<div class="container">
			<h1 class="form-title">Update User Details</h1>
			<form action="${pageContext.request.contextPath}/updateUser" method="post" enctype="multipart/form-data">
				<div class="main-user-info">
					<div class="user-input-box">
						<label for="fullName">Full Name</label> 
						<input type="text" name="userName" placeholder="Enter your full Name" value="${user.fullName}"//>
					</div>
					<div class="user-input-box">
						<label for="email">Email</label> 
						<input type="text" name="userEmail" placeholder="Enter your full Email" value="${user.email}" readonly/>
					</div>
					<div class="user-input-box">
						<label for="email">Phone Number</label> 
						<input type="text" name="userNumber" placeholder="Enter Phone Number" value="${user.phoneNum}"/>
					</div>
					<div class="user-input-box">
						<label for="address">Address</label> 
						<input type="text" name="userAddress" placeholder="Enter your Address" value="${user.address}"/>
					</div>
					<div class="user-input-box">
						<label style="color: rgb(95, 93, 93);" class="img-upload" for="upload">Upload Photo</label> 
						<input type="file" name="userPhoto" id="chooseImage" value="${user.fullName}" onchange="onImageChange()"/>
					</div>
					<img id="imagePreview" src="${pageContext.request.contextPath}/images/${user.photoPath}?v=${time}" height="200px" width="200px"/>
					<div class="user-input-box">
						<label for="password">Password</label> 
						<input type="password" name="userPassword" placeholder="Enter Password" value="${user.password}"/>
					</div>
				</div>
				<div class="gender-details-box">
					<span class="gender-title">Gender</span>
					<div class="gender-category">
						<input type="radio" name="gender" id="male" value="Male" <c:if test="${fn:toLowerCase(user.gender) eq 'male'}"> Checked</c:if>/> 
						<label for="male">Male</label> 
						<input type="radio" name="gender" id="female" value="Female" <c:if test="${fn:toLowerCase(user.gender) eq 'female'}"> Checked</c:if>/> 
						<label for="female">Female</label>
						<input type="radio" name="gender" id="other" value="Other" <c:if test="${fn:toLowerCase(user.gender) eq 'other'}"> Checked</c:if>/> 
						<label for="others">Other</label>
					</div>
				</div>
				<div class="form-submit-btn">
					<input type="submit" value="Update" />
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function onImageChange(){
			var imageChooser=document.getElementById("chooseImage");
			var imagePreview=document.getElementById("imagePreview");
			imagePreview.src=URL.createObjectURL(imageChooser.files[0]);
	}
	</script>
</body>
</html>
    