<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Page Not Found</title>
  <style>
    body {
      background-color: rgb(11, 11, 11);
    }

    .container {
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
    }

    button {
      position: relative;
      padding: 1em 1.8em;
      outline: none;
      border: 1px solid #303030;
      background: #212121;
      color: #ae00ff;
      text-transform: uppercase;
      letter-spacing: 2px;
      font-size: 15px;
      overflow: hidden;
      transition: 0.2s;
      border-radius: 20px;
      cursor: pointer;
      font-weight: bold;
    }

    button:hover {
      box-shadow: 0 0 10px #ae00ff, 0 0 25px #001eff, 0 0 50px #ae00ff;
      transition-delay: 0.2s;
    }

    button span {
      position: absolute;
    }

    .back-home-btn {
      margin-left: 300px;
    }
  </style>
</head>

<body>
  <div class="container">
    <div class="img-section">
      <img class="gif-img" src="${pageContext.request.contextPath}/images/pageNotFound.gif" alt="" />
    </div>
    <div class="back-home-btn">
      <a href="${pageContext.request.contextPath}/homepage"><button>
          <span></span>
          <span></span>
          <span></span>
          <span></span> TAKE ME HOME
        </button></a>
    </div>
  </div>
</body>

</html>