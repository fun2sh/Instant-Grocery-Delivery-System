<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- HEADER -->
<%@include file="/WEB-INF/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>List of all Categories</h1>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Image</th>
                <th>Category Name</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
            </thead>
            <c:forEach items="${categorylist}" var="category">
                <tr>
                    <td><img src="<c:url value="/resources/images/${category.categoryName}.png"/>" alt="image"
                             style="height:50" style="width:50"/></td>
                    <td>${category.categoryName}</td>
                    <td>${category.categoryDesc}</td>
                    <td>
                        <a href="<spring:url value="/admin/category/edit-category/${category.categoryName}"/>">
                            <span class="glyphicon glyphicon-pencil"></span></a>
                        <a href="<spring:url value="/admin/category/delete-category/${category.categoryName}"/>">
                            <span class="glyphicon glyphicon-remove"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/admin/category/add-category"/>" class="btn btn-primary">Add Category</a>
        <!-- FOOTER -->
<%@include file="/WEB-INF/template/footer.jsp" %>