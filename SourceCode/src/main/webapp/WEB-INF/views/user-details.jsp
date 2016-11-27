<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- HEADER -->
<%@include file="/WEB-INF/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>User Details</h1>
        </div>

        <div class="container">
            <div class="row">

                <div class="col-md-5">
                    <h3>${user.userName}</h3>
                    <p>${user.accountType}</p>
                    <p>${user.userId}</p>

                </div>
            </div>
        </div>

<%@include file="/WEB-INF/template/footer.jsp" %>