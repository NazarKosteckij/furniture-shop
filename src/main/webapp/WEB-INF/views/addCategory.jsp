<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 16.01.2016
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/materialize.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />">
    <script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="<c:url value="/resources/js/materialize.js"/>"></script>
    <link href="http://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>Admin Panel</title>
</head>
<body>
    <jsp:include page="adminNavigationBar.jsp" />
    <main>
        <div class="container">
            <div class="row">
                <div class="input-field">
                    <form  method="post" enctype="multipart/form-data">
                        <div class="row">
                            <div class="input-field col s12 m6">
                                <input id="name" name="name" type="text" required class="validate">
                                <label for="name">Назва</label>
                            </div>
                        </div>
                        <div class="input-field">
                            <input class="btn" type="submit" value="Додати"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </main>
</body>
</html>
