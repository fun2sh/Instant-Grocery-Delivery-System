<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Instant Grocery</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/shop-homepage.css" />" rel="stylesheet">

</head>
<!-- NAVBAR
================================================== -->
<body>

<div class="container">
    <sec:authentication var="principal" property="principal" />
    <nav class="navbar navbar-inverse navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value="/"/>">Instant Grocery</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="<c:url value="/"/>">Home</a></li>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <c:if test="${principal.accountType != 'STORE'}">
                            <li><a href="<c:url value="/product/productList"/>">All Products</a></li>
                        </c:if>
                        <c:if test="${principal.accountType == 'STORE'}">
                            <li><a href="<c:url value="/store/product/productList"/>">My Product List</a></li>
                        </c:if>
                    </c:if>

                    <li><a href="#contact">Contact</a></li>
                </ul>

                <ul class="nav navbar-nav pull-right">

                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <li><a>Welcome: ${principal.userName}</a></li>

                        <c:if test="${principal.accountType == 'CUSTOMER'}">
                            <li><a href="<c:url value="/customer/cart"/>">My Cart</a></li>
                            <li><a href="<c:url value="/customer/orders"/>">My Orders</a></li>
                            <li><a href="<c:url value="/customer/profile"/>">My Profile</a></li>
                        </c:if>
                        <c:if test="${principal.accountType == 'STORE'}">
                            <li><a href="<c:url value="/store/profile"/>">My Profile</a></li>
                        </c:if>
                        <c:if test="${principal.accountType == 'ADMIN'}">
                            <li><a href="<c:url value="/admin/profile"/>">My Profile</a></li>
                            <li><a href="<c:url value="/admin"/>">Admin Panel</a></li>
                        </c:if>
                        <li><a href="<c:url value="/logout"/>">Logout</a></li>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name == null}">
                        <li><a href="<c:url value="/login"/>">Login</a></li>

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Register <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="<c:url value="/registeradmin"/>">Register as Admin</a></li>
                                <li><a href="<c:url value="/registerstore"/>">Register as Store</a></li>
                                <li><a href="<c:url value="/registercustomer"/>">Register as Customer</a></li>

                            </ul>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
</div>
