<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:useBean id="now" class="java.util.Date" />
<!-- HEADER -->
<%@include file="/WEB-INF/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Review your Order Details</h1>
        </div>

        <div class="container">
            <div class="row">

                <form:form commandName="order" class="form-horizontal">
                    <div class="col-md-6 col-md-offset-3">

                        <div class="text-center">
                            <h1>Receipt</h1>
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <address>
                                    <strong>Shipping Address</strong><br/>
                                        ${shippingAddress.addressLine1}<br/>
                                        ${shippingAddress.addressLine2}<br/>
                                        ${shippingAddress.city}, ${shippingAddress.state}<br/>
                                        ${shippingAddress.country}, ${shippingAddress.zipcode}<br/>
                                </address>
                            </div>
                            <div class="col-md-6 text-right">
                                <p>Shipping Date: <fmt:formatDate type="date" value="${now}"/></p>
                            </div>
                        </div>

                        <div class="row">
                            <table class="table table-hover">
                                <table class="table table-striped table-hover">
                                    <thead>
                                    <tr class="bg-success">
                                        <th>Image</th>
                                        <th>Product Name</th>
                                        <th>Brand</th>
                                        <th>Quantity</th>
                                        <th>Total Price</th>
                                    </tr>
                                    </thead>
                                    <c:set var="cartTotal" value="${0}"/>
                                    <c:forEach items="${orderedItems}" var="item">
                                        <tr>
                                            <td><img
                                                    src="<c:url value="/resources/images/${item.product.productId}.png"/>"
                                                    alt="image"
                                                    style="height:50" style="width:50"/></td>
                                            <td>${item.product.productName}</td>
                                            <td>${item.product.brand}</td>
                                            <td>${item.quantity}</td>
                                            <td>${item.totalPrice}</td>
                                            <c:set var="cartTotal" value="${item.totalPrice + cartTotal}"/>
                                        </tr>
                                    </c:forEach>
                                </table>

                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td class="text-right">
                                        <h4><strong>Grand Total: </strong></h4>
                                    </td>
                                    <td class="text-right">
                                        <h4><strong>$ ${cartTotal}</strong></h4>
                                    </td>
                                </tr>

                            </table>
                        </div>

                        <br/><br/>

                    </div>
                </form:form>
            </div>
        </div>

        <a href="<spring:url value="/"/>" class="btn btn-warning">Cancel</a>
        <a href="<spring:url value="/customer/order/confirm/${cartId}"/>" class="btn btn-primary">Place Order</a>

        <!-- FOOTER -->
<%@include file="/WEB-INF/template/footer.jsp" %>