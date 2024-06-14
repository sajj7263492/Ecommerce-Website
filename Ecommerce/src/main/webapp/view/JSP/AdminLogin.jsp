<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Admin Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/CSS/AdminLogin.css" />
  </head>
  <body>
    <div class="login-form">
    
    <h3 style="color:red; text-align:center;"> <c:out value="${sessionScope.adminLoginError}" /></h3>
        	<%session.removeAttribute("adminLoginError"); %>       	
   
      <h1 class="admin-heading">Admin Login</h1>
      <div class="form-input">
        <form action="/Ecommerce/admin" method="post">
          <label for="">Admin ID</label>
          <input type="text" name="email" class="input" placeholder="Username" />
          <label for="">Password</label>
          <input type="password" name="password" class="input" placeholder="Password" />
          <div class="input" style="display: flex">
          </div>
          <input type="submit" value="Login" />
        </form>
      </div>
    </div>
  </body>
</html>
    