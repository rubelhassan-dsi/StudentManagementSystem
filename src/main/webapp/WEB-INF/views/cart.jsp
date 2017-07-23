<%--
  Created by IntelliJ IDEA.
  User: rubel
  Date: 7/24/17
  Time: 12:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.1/angular.min.js"></script>
    <script src="/resources/js/controller.js"></script>

</head>
<body>

<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Cart</h1>
            <p>All the selected products in your
                cart</p>
        </div>
    </div>
</section>
<section class="container" ng-app="cartApp">
    <div ng-controller="cartCtrl" ng-
         init="initCartId('${cartId}')">
        <div>
            <a class="btn btn-danger pull-left" ng-click="clearCart()"> <span
                    class="glyphicon glyphicon-remove-sign"></span> Clear Cart
            </a> <a href="#" class="btn btn-successpull-right"> <span
                class="glyphicon-shopping-cartglyphicon"></span> Check out
        </a>
        </div>
        <table class="table table-hover">
            <tr>
                <th>Product</th>
                <th>Unit price</th>
                <th>Qauntity</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            <tr ng-repeat="item in cart.cartItems">
                <td>{{item.product.productId}}-
                    {{item.product.name}}</td>
                <td>{{item.product.unitPrice}}</td>
                <td>{{item.quantity}}</td>
                <td>{{item.totalPrice}}</td>
                <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
                    <span class="glyphicon glyphicon-remove" /> Remove
                </a></td>
            </tr>
            <tr>
                <th></th>
                <th></th>
                <th>Grand Total</th>
                <th>{{cart.grandTotal}}</th>
                <th></th>
            </tr>
        </table>
        <a href="<spring:url value="/products" />" class="btn btn-default">
            <span class="glyphicon-hand-left glyphicon">
            </span> Continue shopping
        </a>

        <a href="#" class="btn btn-warning btn-large"
           click="addToCart('${product.productId}')">
            <span class="glyphicon-shopping-cartglyphicon"></span> Order Now
        </a>
        <a href="<spring:url value="/cart" />" class="btn btn-default">
            <span class="glyphicon-hand-right glyphicon"></span> View Cart
        </a>
    </div>
</section>
</body>
</html>
