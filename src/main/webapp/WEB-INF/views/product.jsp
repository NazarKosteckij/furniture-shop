<%--@elvariable id="images" type="java.util.List<com.test.rest.models.Image>"--%>
<%--@elvariable id="product" type="com.test.rest.models.Product"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html ng-app="catalog">
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/materialize.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />">
    <script src="<c:url value="/resources/js/lib/jquery.min.js"/>" > </script>
    <script src="<c:url value="/resources/js/materialize.js"/>"> </script>
    <script src="<c:url value="/resources/js/lib/angular.min.js" /> "> </script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.0/angular-route.js"> </script>
    <script src="<c:url value="/resources/js/Application.js" /> "> </script>
    <link href="http://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>Home</title>
    <style>
        .card-image
        {
            height: 200px;
            overflow: hidden;
        }
        .image {
            position: absolute;
            margin: auto;
            min-height: 100%;
            min-width: 100%;

            /* For the following settings we set 100%, but it can be higher if needed
            See the answer's update */
            left: -100%;
            right: -100%;
            top: -100%;
            bottom: -100%;
        }
    </style>
</head>

<body >
<jsp:include page="navigationBar.jsp" />
<main>
    <div class="container">
        <h2>${product.name}</h2>
        <div class="materialbox">
            <div class="row">
                <div class="center ">
                    <div class="col s12 m3 ">
                        <img  class="responsive-img materialboxed" alt="${product.image.title}" src="/img/${product.image.uri}">
                    </div>
                </div>
                <div class="col s12 m9">
                    <div class="description flow-text">
                        ${product.description}
                    </div>
                </div>
            </div>
            <div class="">
                <ul class="row">
                    <c:forEach var="image" items="#{images}">
                        <li class="col s3 m2"><img  class=" responsive-img materialboxed" src="/img/<c:out value="${image.uri}"/>"
                                  style="width: 170px;
                                  padding: 10px;"></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</main>

<c:import url="footer.jsp"/>
</body>
</html>

