<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/view/CSS/ProductList.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
</head>
<body>
 <c:set var="time" value="<%=new Date().getTime()%>"/>
	 <div class="main-container">
      <div class="wrapper box1">
        <div class="sidebar">
          <div class="img">
            <img class="image-logo" src="${pageContext.request.contextPath}/images/homepage-images/logo.png" alt="" />
          </div>

          <ul>
            <li>
              <a href="${pageContext.request.contextPath}/showOrders" class="icon-a"
                ><i class="fa fa-shopping-bag" aria-hidden="true"></i
                >&nbsp;&nbsp; Order
              </a>
            </li>
            <li style="background-color: #4414a4">
              <a href="${pageContext.request.contextPath}/viewProductList" class="icon-a" style="color: white"
                ><i class="fa fa-product-hunt" aria-hidden="true"></i
                >&nbsp;&nbsp; Product
              </a>
            </li>
          </ul>
        </div>
      </div>
      <div class="box2">
        <div class="box2-header">
          <a href="${pageContext.request.contextPath}/adminLogout"><input class="btn" type="button" value="LOGOUT" /></a>
        </div>
        <div class="product-heading">
          <div class="add-product">
            <h2>Products</h2>
          </div>
          <div class="add-product">
          <a href="${pageContext.request.contextPath}/view/JSP/AddProduct.jsp"><button class="add-btn">
              <span>Add Product</span>
            </button></a>
            
          </div>
        </div>
        <div class="table-container">
        
       <h3 style="color:green; text-align:center;"> <c:out value="${sessionScope.updateStatus}" /></h3>
        <%session.removeAttribute("updateStatus"); %>
        
        <h3 style="color:green; text-align:center;"> <c:out value="${sessionScope.addStatus}" /></h3>
        <%session.removeAttribute("addStatus"); %>
        
        <h3 style="color:red; text-align:center;"> <c:out value="${sessionScope.deleteStatus}" /></h3>
        	<%session.removeAttribute("deleteStatus"); %>
        
          <table class="ProductTable">
            <tr>
              <th>Product ID</th>
              <th>Image</th>
              <th>Product Name</th>
              <th>Price</th>
              <th>Brand</th>
              <th>Action</th>
            </tr>
            
            <%-- <c:set var="userDao" value="<%=new model.UserDAO()%>" />
			<c:set var="productList" value="${userDao.fetchProducts()}" /> --%>
            <c:forEach var="product" items="${productList}">
            <tr>
              <td style="font-weight: bold">${product.productId}</td>
              <td><img class="product-img" src="${pageContext.request.contextPath}/images/${product.productImage}?v=${time}" alt="" /></td>
              <td>${product.productName}</td>
              <td>${product.productPrice}</td>
              <td>${product.productBrand}</td>
              <td>
                <a href="${pageContext.request.contextPath}/editProduct?productId=${product.productId}"> <button class="Edit">Edit</button></a>
                <a href="${pageContext.request.contextPath}/deleteProduct?productId=${product.productId}"> <button class="Delete">Delete</button></a>
              </td>
            </tr>
       </c:forEach>
          </table>
        </div>
      </div>
    </div>
  </body>
</body>
</html>