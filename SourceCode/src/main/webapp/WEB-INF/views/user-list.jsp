<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- HEADER -->
<%@include file="/WEB-INF/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>List of all Users in the system</h1>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Username</th>
                <th>Account Type</th>
                <th>Approval Status</th>
                <th>User Active</th>
                <th>Action</th>
            </tr>
            </thead>
            <c:forEach items="${userlist}" var="user">
                <tr>
                    <td>${user.userName}</td>
                    <td>${user.accountType}</td>
                    <td>${user.approved  ? 'Yes' : 'No'}</td>
                    <td>${user.active ? 'Yes' : 'No'}</td>
                    <td>
                        <a href="<spring:url value="/admin/user/view-user/${user.userName}"/>">
                            <span class="glyphicon glyphicon-info-sign"></span></a>

                    </td>
                </tr>
            </c:forEach>
        </table>


        <!-- FOOTER -->
<%@include file="/WEB-INF/template/footer.jsp" %>