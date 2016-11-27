<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- HEADER -->
<%@include file="/WEB-INF/template/header.jsp" %>

<div class="container-wrapper">

    <div class="container">


        <div class="row">

            <div class="col-md-3">
                <p class="lead">Shop Name</p>
                <div class="list-group">
                    <a href="#" class="list-group-item">Category 1</a>
                    <a href="#" class="list-group-item">Category 2</a>
                    <a href="#" class="list-group-item">Category 3</a>
                </div>
            </div>

            <div class="col-md-9" text>

            </div>

            <div class="col-md-9">
                <div class="row">
                    <div class="input-group">
                        <input type="text" class="form-control">
                        <span class="input-group-btn"><button class="btn btn-default"
                                                              type="button">Search</button></span>
                    </div>
                </div>
                <br/>
                <div class="row">

                    <div class="col-md-4">
                        <div class="thumbnail">
                            <img src="<c:url value="/resources/images/${product.productName}.png"/>" alt=""
                                 style="height:150" style="width:150">
                            <div class="caption">
                                <h4 class="pull-right">$24.99</h4>
                                <h4><a href="#">First Product</a>
                                </h4>
                                <p>See more snippets like this online store item at </p>
                            </div>

                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="thumbnail">
                            <img src="<c:url value="/resources/images/${product.productName}.png"/>" alt=""
                                 style="height:150" style="width:150">
                            <div class="caption">
                                <h4 class="pull-right">$24.99</h4>
                                <h4><a href="#">First Product</a>
                                </h4>
                                <p>See more snippets like this online store item at </p>
                            </div>

                        </div>
                    </div>


                </div>

            </div>

        </div>

    </div>
    <!-- /.container -->
</div>

</div>

<!-- FOOTER -->
<%@include file="/WEB-INF/template/footer.jsp" %>