<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- HEADER -->
<%@include file="/WEB-INF/template/header.jsp"%>

<div class="container" ">
    <div class="row">
        <div class="col-md-5">
            <img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image" style="width:100%; height:300px;"/>
        </div>

        <div class="col-md-5">
            <h3>${product.productName}</h3>
            <p>${product.productDescription}</p>
            <p>
                <strong>Manufacturer</strong> : ${product.productManufacturer}
            </p>
            <p>
                <strong>Category</strong> : ${product.productCategory}
            </p>
            <p>
                <strong>Condition</strong> : ${product.productCondition}
            </p>
            <p>${product.productPrice} USD</p>

            <br/>

            <c:set var="role" scope="page" value="${param.role}" />
            <c:set var="url" scope="page" value="/product/product-list" />
            <c:if test="${role='admin'}">
                <c:set var="url" scope="page" value="/admin/product-inventory" />
            </c:if>

            <p ng-controller="cartCtrl">
                <a href="<c:url value="${url}"/>" class="btn btn-default">Back</a>
                <a href="#" class="btn btn-warning"
                   ng-click="addToCart('${product.productId}')"><span
                        class="glyphicon glyphicon-shopping-cart"></span>Order Now</a>
                <a href="<spring:url value="/customer/cart"/>" class="btn btn-default"><span
                        class="glyphicon glyphicon-hand-right"></span>View Cart</a>
            </p>
        </div>
    </div>
</div>



        <!-- FOOTER -->
<%@include file="/WEB-INF/template/footer.jsp"%>