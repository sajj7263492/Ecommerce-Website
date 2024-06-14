
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Add Product</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/CSS/AddProduct.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
  </head>
  <body>
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
        </div>
        <div class="form">
          <form action="${pageContext.request.contextPath}/addProduct" method="post" enctype="multipart/form-data">
            <div class="product-input-dtls">
              <label for="ProductID">Product ID</label>
              <input type="text" name="productId" required/>
              <label for="ProductName">Product Name</label>
              <input type="text" name="productName"  required/>
              <label for="Pice">Price</label>
              <input type="text" name="productPrice"  required/>
              <label for="Brand">Brand</label>
              <input type="text" name="productBrand"  required/>
              <label for="ProductImg">Upload Image</label>
              <input type="file" name="productImage"  required/>
            </div>
            <input type="submit" value="Add" />
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
