<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Назар
  Date: 07.02.2016
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error ${code == null ? "404" : code}/></title>

    <link rel="stylesheet" href="<c:url value="/resources/css/materialize.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />">
</head>
<body>
    <c:import url="navigationBar.jsp"/>
    <main>
        <div class="container">
            <h1 >Error ${code == null ? "404" : code}</h1>
            <h2 class="flow-text">${message == null ? "Not found" : message}</h2>
        </div>
    </main>

    <c:import url="footer.jsp"/>
</body>
</html>
