<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Sign in Page</title>
<link rel="stylesheet" href="../CSS/UserLogin.css" />
</head>
<body>
	<div class="container">
		<div class="main-div">
			<div class="box1">
				<img class="image" src="../../images/login-images/login.png" alt="" />
			</div>

			<div class="box2">
				<div class="form-div">
					<div class="input">
					<c:if test="${not empty sessionScope.loginError}">
  					<h3 style="color:red;">${sessionScope.loginError}</h3>
  					<% session.removeAttribute("loginError"); %>
					</c:if>
					
					<h3 style="color:green;">${sessionScope.userRegistrationStatus}</h3>
  					<% session.removeAttribute("userRegistrationStatus"); %>
					
						<h1 class="Sign-in" style="color: rgb(240, 178, 20)">Sign in</h1>
					</div>
					<form class="form" method="post" action="/Ecommerce/userlogin">
						<div class="input">
							<label for="name">User Email</label> 
							<input type="email" class="login" id="" name="email" placeholder="Enter Email"  required/>
						</div>

						<div class="input">
							<label for="email">Password</label> 
							<input type="Password" class="login" id="" name="password" placeholder="Enter Password" required />
						</div>
						<input type="submit" value="Login" class="btn">

						<div class="input" style="display: flex">
							<div class="new-user">
								<p>
									New User? 
									<a href="${pageContext.request.contextPath}/view/JSP/UserRegistration.jsp">Signup</a>
								</p>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
