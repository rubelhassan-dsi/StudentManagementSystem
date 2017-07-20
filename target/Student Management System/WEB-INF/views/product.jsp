<%--
  Created by IntelliJ IDEA.
  User: rubel
  Date: 7/19/17
  Time: 12:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
${author}<c:out value="${author}"/>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Products</h1>
            <p>All the available products in our store</p>
        </div>
    </div>
</section>
<section>
    <div class="container">
        <div class="row">
                <div class="col-sm-9 col-md-6" style="padding-bottom: 15px;">
                    <div class="thumbnail">
                        <div class="caption">
                            <h3>Product Name: ${product.getName()}</h3>
                            <p>Description: ${product.description}</p>
                            <p>Product Price: ${product.unitPrice} USD</p>
                            <p>Manufacturere: ${product.manufacturer}</p>
                            <p>Available ${product.unitsInStock} units in stock</p>
                            <a href=" <spring:url value="/products" />" class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"/></span> All Products
                            </a>
                        </div>
                    </div>
                </div>
        </div>
    </div>
</section>
</body>
</html>
