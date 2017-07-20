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
                <c:forEach items="${products}" var="product">
                <div class="col-sm-6 col-md-3" style="padding-bottom: 15px;">
                        <div class="thumbnail">
                            <div class="caption">
                                <h3>${product.getName()}</h3>
                                <p>${product.description}</p>
                                <p>${product.unitPrice} USD</p>
                                <p>Available ${product.unitsInStock} units in stock</p>
                                <a href=" <spring:url value="/products?id=${product.productId}" />" class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"/></span> Details
                                </a>
                            </div>
                        </div>
                </div>
                </c:forEach>
            </div>
        </div>
    </section>
</body>
</html>
