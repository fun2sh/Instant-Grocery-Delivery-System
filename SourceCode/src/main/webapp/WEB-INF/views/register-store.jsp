<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register Your Store</h1>
            <p class="lead">Please fill in your Store information</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/registerstore"
                   method="post" commandName="store" >
            <form:hidden path="accountType" value=""/>
        <h3>Store Info</h3>

        <div class="form-group">
            <label for="name">Store Name</label><form:errors path="storeName" cssStyle="color: #761c19"/>
            <form:input path="storeName" id="name" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="managername">Manager Name</label><form:errors path="managerName" cssStyle="color: #761c19"/>
            <form:input path="managerName" id="managername" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="email">Manager's Email</label><span style="color: #761c19">${emailErr}</span><form:errors path="managerEmail" cssStyle="color: #761c19"/>
            <form:input path="managerEmail" id="email" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="phone">Store Phone Number</label><form:errors path="storePhone" cssStyle="color: #761c19"/>
            <form:input path="storePhone" id="phone" class="form-control"/>
        </div>


        <div class="form-group">
            <label for="username">Username</label><span style="color: #ff0000">${usernameErr}</span><form:errors path="userName" cssStyle="color: #ff0000"/>
            <form:input path="userName" id="username" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="password">Password</label><form:errors path="password" cssStyle="color: #761c19"/>
            <form:password path="password" id="password" class="form-control"/>
        </div>

        <h3>Store's Address Details</h3>

        <div class="form-group">
            <label for="address1">Address Line 1</label><form:errors path="storeAddress.addressLine1" cssStyle="color: #761c19"/>
            <form:input path="storeAddress.addressLine1" id="address1" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="address2">Address Line 2</label>
            <form:input path="storeAddress.addressLine2" id="address2" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="city">City</label><form:errors path="storeAddress.city" cssStyle="color: #761c19"/>
            <form:input path="storeAddress.city" id="city" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="state">State</label><form:errors path="storeAddress.state" cssStyle="color: #761c19"/>
            <form:input path="storeAddress.state" id="state" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="country">Country</label><form:errors path="storeAddress.country" cssStyle="color: #761c19"/>
            <form:input path="storeAddress.country" id="country" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="zipcode">Zipcode</label><form:errors path="storeAddress.zipcode" cssStyle="color: #761c19"/>
            <form:input path="storeAddress.zipcode" id="zipcode" class="form-control"/>
        </div>


        <br/><br/>

        <input type="submit" value="Submit" class="btn btn-default"/>
        <a href="<c:url value="/"/>" class="btn btn-danger">Cancel</a>

        </form:form>


        <!-- FOOTER -->
<%@ include file="/WEB-INF/template/footer.jsp" %>