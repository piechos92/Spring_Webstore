<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/webstore/resource/js/controllers.js"></script>
    <title>Produkt</title>
</head>
<body>
    <section class="container" ng-app="cartApp">
        <div class="row">
            <div class="col-md-5">
                <img src="<c:url value="/resource/images/${product.productId}.jpeg"/>" alt="image" style="width:100%"/>
            </div>
            <div class="col-md-5">
                <h3>${product.name}</h3>
                <p>${product.description}</p>
                <p>
                    <strong>
                        <spring:message code="product.p.productId"/>:
                    </strong>
                    <span class="label label-warning">${product.productId}</span>
                </p>
                <p>
                    <strong>
                        <spring:message code="product.p.manufacturer"/>
                    </strong>: ${product.manufacturer}
                </p>
                <p>
                    <strong>
                        <spring:message code="product.p.category"/>
                    </strong>: ${product.category}
                </p>
                <p>
                    <strong>
                        <spring:message code="product.p.condition"/>
                    </strong>: ${product.condition}
                </p>
                <p>
                    <strong>
                        <spring:message code="product.p.unitsInStock"/>
                    </strong>: ${product.unitsInStock}
                </p>
                <h4>${product.unitPrice} PLN</h4>
                <p ng-controller="cartCtrl">
                    <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')">
                    <span class="glyphicon-shopping-cart glyphicon"></span> Zamów teraz </a>
                    <a href="<spring:url value="/cart" />" class="btn btn-default">
                        <span class="glyphicon-hand-right glyphicon">Koszyk</span>
                    </a>
                    <a href='<spring:url value="/products"/>' class="btn btn-default">
                        <span class="glyphicon-hand-left glyphicon">Wstecz</span>
                    </a>
                </p>
            </div>
        </div>
    </section>
</body>
</html>
