<%--
  Created by IntelliJ IDEA.
  User: rubel
  Date: 7/21/17
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Product Not Found</title>
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1 class="alert alert-danger"> There is no
                        product found with the Product id
                        ${invalidProductId}</h1>
                </div>
            </div>
        </section>
        <section>
            <div class="container">
                <p>${url}</p>
                <p>${exception}</p>
            </div>
            <div class="container">
                <p>
                    <a href="<spring:url value="/products" />"
                       class="btn btn-primary">
        <span class="glyphicon-hand-left glyphicon">
        </span> products
                    </a>
                </p>
            </div>
        </section>
    </body>
</html>
