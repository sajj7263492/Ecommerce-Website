<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.Date" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Edit Product</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/CSS/AddProduct.css" />
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
                >&nbsp;&nbsp;Product
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
            <h2>Edit Product</h2>
          </div>
        </div>
        <div class="form">
          <form action="${pageContext.request.contextPath}/updateProduct" method="post" enctype="multipart/form-data">
            <div class="product-input-dtls">
              <label for="productID">Product ID</label>
              <input type="text" name="productId" id="productID" value="${product.productId}" readonly/>
              <label for="productName">Product Name</label>
              <input type="text" name="productName" id="productName" value="${product.productName }" />
              <label for="price">Price</label>
              <input type="text" name="productPrice" id="price" value="${product.productPrice}" />
              <label for="brand">Brand</label>
              <input type="text" name="productBrand" id="brand" value="${product.productBrand}"/>
              <label for="productImg">Image</label>
              <input type="file" name="productImage" id="chooseImage" onchange="onImageChange()"/>
              <img id="imagePreview" src="${pageContext.request.contextPath}/images/${product.productImage}?v=${time}" height="100px" width="100px"/>
            </div>
            <input type="submit" value="Update" />
          </form>
        </div>
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
