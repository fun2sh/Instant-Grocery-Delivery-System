<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:useBean id="now" class="java.util.Date" />
<!-- HEADER -->
<%@include file="/WEB-INF/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Thank you for Placing Order</h1>
                </div>
            </div>
        </section>

        <section class="container">
            <p>
                <a href="<spring:url value="/"/>" class="btn btn-default">Shop More</a>
            </p>
        </section>
    </div>
</div>

<%@include file="/WEB-INF/template/footer.jsp" %>