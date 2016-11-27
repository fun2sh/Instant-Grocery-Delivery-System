<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- HEADER -->
<%@include file="/WEB-INF/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>List of all Products in your Store</h1>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Image</th>
                <th>Product Name</th>
                <th>Description</th>
                <th>Category</th>
                <th>Price</th>
                <th>Units in stock</th>
                <th>Brand</th>
                <th>Action</th>
            </tr>
            </thead>
            <c:forEach items="${productlist}" var="product">
                <tr>
                    <td><img src="<c:url value="/resources/images/${product.productName}.png"/>" alt="image"
                             style="height:50" style="width:50"/></td>
                    <td>${product.productName}</td>
                    <td>${product.productDescription}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productPrice}</td>
                    <td>${product.unitInStock}</td>
                    <td>${product.brand}</td>
                    <td>
                        <a href="<spring:url value="/admin/category/edit-category/${product.productId}"/>">
                            <span class="glyphicon glyphicon-pencil"></span></a>
                        <a href="<spring:url value="/admin/category/delete-category/${product.productId}"/>">
                            <span class="glyphicon glyphicon-remove"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/store/product/add-product"/>" class="btn btn-primary">Add Product</a>
        <!-- FOOTER -->
<%@include file="/WEB-INF/template/footer.jsp" %>