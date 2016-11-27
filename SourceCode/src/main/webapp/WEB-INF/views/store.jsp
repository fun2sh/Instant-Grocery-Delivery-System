<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- HEADER -->
<%@include file="/WEB-INF/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Store Page</h1>
        </div>

        <div>
            <h3>Maintain Products</h3>
            <a href="<c:url value="/store/product/productList"/>" class="btn btn-primary">My Product List</a>
            <a href="<c:url value="/store/product/add-product"/>" class="btn btn-primary">Add a new product</a>
            <br/>
        </div>


        <!-- FOOTER -->
<%@include file="/WEB-INF/template/footer.jsp"%>