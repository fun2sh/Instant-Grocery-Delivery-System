<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- HEADER -->
<%@include file="/WEB-INF/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Details of your cart</h1>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Image</th>
                <th>Product Name</th>
                <th>Brand</th>
                <th>Quantity</th>
                <th>Total Price</th>
                <th>Action</th>
            </tr>
            </thead>
            <c:set var="cartTotal" value="${0}"/>
            <c:forEach items="${cartItemList}" var="item">
                <tr>
                    <td><img src="<c:url value="/resources/images/${item.product.productId}.png"/>" alt="image"
                             style="height:50" style="width:50"/></td>
                    <td>${item.product.productName}</td>
                    <td>${item.product.brand}</td>
                    <td>${item.quantity}</td>
                    <td>${item.totalPrice}</td>
                    <c:set var="cartTotal" value="${item.totalPrice + cartTotal}" />
                    <td>
                        <a href="<spring:url value="/customer/cart/edit/${item.cartProductId}"/>">
                            <span class="glyphicon glyphicon-pencil"></span></a>
                        <a href="<spring:url value="/customer/cart/remove/${item.cartProductId}"/>">
                            <span class="glyphicon glyphicon-remove"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p>Order Total = ${cartTotal}</p>
        <a href="<spring:url value="/"/>" class="btn btn-warning">Shop More</a>

        <a href="<spring:url value="/customer/order/proceed/${cartId}"/>" class="btn btn-primary">Proceed to checkout</a>

        <!-- FOOTER -->
<%@include file="/WEB-INF/template/footer.jsp" %>