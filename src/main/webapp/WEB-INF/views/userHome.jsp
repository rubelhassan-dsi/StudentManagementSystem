<%--
  Created by IntelliJ IDEA.
  User: rubel
  Date: 7/22/17
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>User Home</title>
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1 class="alert alert-success"> Welcome
                ${user.name}!</h1>
        </div>
    </div>
</section>
<section>
    <div class="container">
        <p>${user.email}</p>
    </div>
    <div class="container">
        <p>
            <a href="<spring:url value="/products" />"
               class="btn btn-primary">
        <span class="glyphicon-hand-right glyphicon">
        </span> products
            </a>
        </p>
    </div>
</section>
</body>
</html>

