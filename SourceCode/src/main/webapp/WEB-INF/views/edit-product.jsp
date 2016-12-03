<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- HEADER -->
<%@include file="/WEB-INF/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Edit Product from your store</h1>
            <p class="lead">Edit the following details for the product</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/store/product/add-product" method="post"
                   commandName="product" enctype="multipart/form-data">
            <form:hidden path="productId" value=""/>

        <div class="form-group">
            <label for="name">Product Name</label> <form:errors path="productName" cssStyle="color: #761c19"/>
            <form:input path="productName" id="name" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="description">Product Description</label> <form:errors path="productDescription" cssStyle="color: #761c19"/>
            <form:input path="productDescription" id="description" class="form-control"/>
        </div>


        <div class="form-group">
            <label for="category">Select a Category</label><form:errors path="productCategory" cssStyle="color: #761c19"/>
            <form:select path="productCategory" class="form-control" id="category">
                <form:options items="${categorylist}" />
            </form:select>
        </div>

        <div class="form-group">
            <label for="price">Product Price</label> <form:errors path="productPrice" cssStyle="color: #761c19"/>
            <form:input path="productPrice" id="price" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="unitinstock">Units in Stock</label> <form:errors path="unitInStock" cssStyle="color: #761c19"/>
            <form:input path="unitInStock" id="unitinstock" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="brand">Product Brand</label> <form:errors path="brand" cssStyle="color: #761c19"/>
            <form:input path="brand" id="brand" class="form-control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="product-image">Upload Picture</label>
            <form:input path="productImage" id="product-image" type="file" class="form:input-large"/>
        </div>

        <br/><br/>
        <input type="submit" value="Submit" class="btn btn-default"/>
        <a href="<c:url value="/store/product/productList"/>" class="btn btn-danger">Cancel</a>

        </form:form>

        <!-- FOOTER -->
<%@include file="/WEB-INF/template/footer.jsp" %>