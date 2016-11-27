<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div id="login-box">
            <h2>Please Login</h2>

            <c:if test="${not empty message}">
                <div class="alert alert-info">${message}</div>
            </c:if>

            <form name="login-form" action="<c:url value="/login"/>" method="post">
                <c:if test="${not empty errors}">
                    <div class="alert alert-danger">${errors}</div>
                </c:if>
                <div class="form-group">
                    <label for="username">Username </label>
                    <input type="text" id="username" name="username" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="password">Password </label>
                    <input type="password" id="password" name="password" class="form-control"/>
                </div>

                <input type="submit" value="Submit" class="btn btn-default"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>
    </div>
</div>

<!-- FOOTER -->
<%@include file="/WEB-INF/template/footer.jsp" %>