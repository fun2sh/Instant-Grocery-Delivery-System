<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register Customer</h1>
            <p class="lead">Please fill in your information</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/registercustomer"
                   method="post" commandName="customer" >
            <form:hidden path="accountType" value=""/>
        <h3>Personal Info</h3>

        <div class="form-group">
            <label for="name">Name</label><form:errors path="customerName" cssStyle="color: #761c19"/>
            <form:input path="customerName" id="name" class="form-control"/>
        </div>


        <div class="form-group">
            <label for="email">Email</label><span style="color: #761c19">${emailErr}</span><form:errors path="customerEmail" cssStyle="color: #761c19"/>
            <form:input path="customerEmail" id="email" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="phone">Phone Number</label><form:errors path="customerPhone" cssStyle="color: #761c19"/>
            <form:input path="customerPhone" id="phone" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="birthdate">Birth Date</label><form:errors path="birthDate" cssStyle="color: #761c19"/>
            <form:input path="birthDate" id="birthdate" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="username">Username</label><span style="color: #ff0000">${usernameErr}</span><form:errors path="userName" cssStyle="color: #ff0000"/>
            <form:input path="userName" id="username" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="password">Password</label><form:errors path="password" cssStyle="color: #761c19"/>
            <form:password path="password" id="password" class="form-control"/>
        </div>

        <h3>Shipping Address Details</h3>

        <div class="form-group">
            <label for="address1">Address Line 1</label><form:errors path="customerShippingAddress.addressLine1" cssStyle="color: #761c19"/>
            <form:input path="customerShippingAddress.addressLine1" id="address1" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="address2">Address Line 2</label>
            <form:input path="customerShippingAddress.addressLine2" id="address2" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="city">City</label><form:errors path="customerShippingAddress.city" cssStyle="color: #761c19"/>
            <form:input path="customerShippingAddress.city" id="city" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="state">State</label><form:errors path="customerShippingAddress.state" cssStyle="color: #761c19"/>
            <form:input path="customerShippingAddress.state" id="state" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="country">Country</label><form:errors path="customerShippingAddress.country" cssStyle="color: #761c19"/>
            <form:input path="customerShippingAddress.country" id="country" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="zipcode">Zipcode</label><form:errors path="customerShippingAddress.zipcode" cssStyle="color: #761c19"/>
            <form:input path="customerShippingAddress.zipcode" id="zipcode" class="form-control"/>
        </div>

        <h3>Payment Information</h3>

        <div class="form-group">
            <label for="creditcardname">Name</label><form:errors path="paymentDetails.cardName" cssStyle="color: #761c19"/>
            <form:input path="paymentDetails.cardName" id="creditcardname" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="creditcardnumber">Credit Card Number</label><form:errors path="paymentDetails.cardNumber" cssStyle="color: #761c19"/>
            <form:input path="paymentDetails.cardNumber" id="creditcardnumber" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="creditcarddate">Expiry Date</label><form:errors path="paymentDetails.expiryDate" cssStyle="color: #761c19"/>
            <form:input path="paymentDetails.expiryDate" id="creditcarddate" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="cvv">CVV</label><form:errors path="paymentDetails.cvv" cssStyle="color: #761c19"/>
            <form:input path="paymentDetails.cvv" id="cvv" class="form-control"/>
        </div>
        <br/><br/>

        <input type="submit" value="Submit" class="btn btn-default"/>
        <a href="<c:url value="/"/>" class="btn btn-danger">Cancel</a>

        </form:form>


        <!-- FOOTER -->
<%@ include file="/WEB-INF/template/footer.jsp" %>