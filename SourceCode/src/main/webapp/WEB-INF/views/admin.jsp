<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- HEADER -->
<%@include file="/WEB-INF/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator Page</h1>
        </div>

        <div>
            <h3>Maintain Categories</h3>
            <a href="<c:url value="/admin/category/category-list"/>" class="btn btn-primary">Category List</a>
            <a href="<c:url value="/admin/category/add-category"/>" class="btn btn-primary">Add a new Category</a>
            <br/>
        </div>

        <div>
            <h3>Maintain Users</h3>
            <a href="<c:url value="/admin/user/user-list"/>" class="btn btn-primary">View all Users</a>
            <a href="<c:url value="/admin/user/approve-user"/>" class="btn btn-primary">Approve User's Registration</a>
            <br/>
        </div>

        <div>
            <h3>Maintain Orders</h3>
            <a href="<c:url value="/admin/orders/order-list"/>" class="btn btn-primary">View all orders</a>
            <a href="<c:url value="/admin/orders/approve-order"/>" class="btn btn-primary">Authorize Orders</a>
            <br/>
        </div>

<!-- FOOTER -->
<%@include file="/WEB-INF/template/footer.jsp"%>