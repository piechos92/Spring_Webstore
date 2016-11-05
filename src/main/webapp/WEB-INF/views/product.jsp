<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Produkt</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Produkt</h1>
        </div>
    </div>
</section>
<section class="container">
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
            <p>
                <a href="#" class="btn btn-warning btn-large">
                    <span class="glyphicon-shopping-cart glyphicon">Zamów teraz</span>
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
