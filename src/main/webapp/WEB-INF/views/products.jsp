<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/materialize.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />">
    <script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="<c:url value="/resources/js/materialize.js"/>"></script>
    <link href="http://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>Admin Panel</title>
</head>
    <jsp:include page="adminNavigationBar.jsp" />
    <main>
    <div class="container">
        <jsp:include page="adminButtons.jsp"/>
        <table class="centered">
            <thead>
                <tr>
                    <td>№</td>
                    <td>Назва</td>
                    <td  class="col hide-on-small-only">Опис</td>
                    <td>Дія</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr class="row" style="height: 60px;">
                        <td class="col s1"><c:out value="${product.id}"/></td>
                        <td  class="col"><c:out value="${product.name}"/></td>
                        <td  class="col hide-on-small-only">${product.description}</td>
                        <td  class="col s3"> <a class="btn-floating waves-effect waves-light red tooltipped" data-position="left" data-delay="50" data-tooltip="Видалити"  id="<c:out value="${product.id}"/>" ><i class="material-icons small">delete</i></a>
                            <a href="<c:out value="${product.id}"/>" class="btn-floating waves-effect waves-light green tooltipped" data-position="left" data-delay="50" data-tooltip="Редагувати"  id="edit" ><i class="material-icons small">edit</i></a>
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
