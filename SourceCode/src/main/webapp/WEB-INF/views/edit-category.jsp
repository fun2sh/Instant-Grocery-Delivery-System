<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- HEADER -->
<%@include file="/WEB-INF/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Edit the Category</h1>
            <p class="lead">Fill the details below to Edit the Category</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/category/edit-category" method="post"
                   commandName="category" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name">Category Name</label> <form:errors path="categoryName" cssStyle="color: #761c19"/>
            <form:input path="categoryName" id="name" class="form-control" value="${category.categoryName}"
                        readonly="true" fieldclass="x-item-disabled"/>
        </div>

        <div class="form-group">
            <label for="description">Category Description</label> <form:errors path="categoryDesc" cssStyle="color: #761c19"/>
            <form:textarea path="categoryDesc" id="description" class="form-control" value="${category.categoryDesc}"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="category-image">Upload Picture</label>
            <form:input path="categoryImage" id="category-image" type="file" class="form:input-large"/>
        </div>

        <br/><br/>
        <input type="submit" value="Submit" class="btn btn-default"/>
        <a href="<c:url value="/admin/category/category-list"/>" class="btn btn-danger">Cancel</a>

        </form:form>

        <!-- FOOTER -->
<%@include file="/WEB-INF/template/footer.jsp" %>