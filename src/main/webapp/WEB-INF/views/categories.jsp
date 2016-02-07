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
            <jsp:include page="adminButtons.jsp"/>
            <table>
                <thead>
                    <tr>
                        <td>№</td>
                        <td>Iм'я</td>
                        <td>Кількість товарів</td>
                        <td>Дія</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="category" items="${categories}">
                        <tr>
                            <td><c:out value="${category.id}"/></td>
                            <td><c:out value="${category.name}"/></td>
                            <td>${category.products.size()}</td>
                            <td> <a  class="btn-floating waves-effect waves-light red tooltipped" data-position="left" data-delay="50" data-tooltip="Видалити"  id="delete" ><i class="material-icons small">delete</i></a>
                                <a href="<c:out value="${category.id}"/>" class="btn-floating waves-effect waves-light green tooltipped" data-position="left" data-delay="50" data-tooltip="edit"  id="edit" ><i class="material-icons small">edit</i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </main>

    <c:import url="footer.jsp"/>
</body>
</html>
