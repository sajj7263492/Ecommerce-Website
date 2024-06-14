<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Order Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/CSS/OrderList.css" />
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
            <li style="background-color: #4414a4">
              <a href="${pageContext.request.contextPath}/showOrders" class="icon-a" style="color: white"
                ><i class="fa fa-shopping-bag" aria-hidden="true"></i
                >&nbsp;&nbsp; Order
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/viewProductList" class="icon-a"
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
        <div class="order-list">
          <h2 class="heading-order">Orders</h2>
          
          
          <div class="table-container">
            <table class="OrderTable">
              <tr>
                <th>Order ID</th>
                <th>Username</th>
                <th>Items</th>
                <th>Price</th>
                <th>Order Date</th>
                <th>Order Time</th>
              </tr>
	<c:forEach var="order" items="${orderList}">
              <tr>
                <td style="font-weight: bold">${order.orderId}</td>
                <td>
                  <img class="view-cart-img" src="${pageContext.request.contextPath}/images/${order.userImage}?v=${time}" alt="" />
                  <h4></h4>
                  <p>${order.fullName}</p>
                </td>
                <td>
                  <img class="view-cart-img" src="${pageContext.request.contextPath}/images/${order.productImage}?v=${time}" alt="" />
                  <h4>${order.productName}</h4>
                  <p>${order.productBrand}</p>
                </td>

                <td>${order.prodctPrice}</td>
                <td>${order.orderDate}</td>
                <td>${order.orderTime}</td>
              </tr>
              </c:forEach>
            </table>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
