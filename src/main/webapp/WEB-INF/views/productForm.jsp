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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Create A Product</h1>
        </div>
    </div>
</section>
<section>
    <a href="<c:url value="/logout" />">Logout</a>
    <form:errors path="product.*" class="alert alert-danger"
                 element="div"/>
    <div class="container">
        <div class="row">
                <form method="POST" action="/products/create" enctype="multipart/form-data">
                    <input type="hidden" id="user_id">
                    Name: <input type="text" id="name" required="required" name="name"><br>
                    unitPrice: <input type="text" id="unitPrice" name="unitPrice"><br>
                    description: <input type="text" id="description" name="description"><br>
                    manufacturer: <input type="text" id="manufacturer"  name="manufacturer"><br>
                    category: <input type="text" id="category"  name="category"><br>
                    unitsInStock: <input type="text" id="unitsInStock"  name="unitsInStock"><br>
                    unitsInOrder: <input type="text" id="unitsInOrder"  name="unitsInOrder"><br>
                    availability: <input type="text" id="availability"  name="availability"><br>
                    state: <input type="text" id="state"  name="state"><br>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="productImage">
                            Upload Product Image:
                        </label>

                        <div class="col-lg-10">
                            <input type="file" id="productImage" name="productImage" class="form:input-large" />
                        </div>
                    </div>

                    <input type="submit" value="Submit">
                </form>

        </div>
    </div>
</section>
</body>
</html>
