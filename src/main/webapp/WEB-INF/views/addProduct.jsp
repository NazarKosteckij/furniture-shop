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
    <title>Admin Panel | Add Product</title>
</head>
<body>
         <jsp:include page="adminNavigationBar.jsp" />
         <main>
         <div class="container">

                 <div id="admin-action">
                     <%--<jsp:include page="adminButtons.jsp"/>--%>
                 </div>
                 <div class="row">
                     <div class="input-field">
                         <form method="post" enctype="multipart/form-data">
                         <div class="row">
                             <div class="input-field col s12 m6">
                                 <input id="name" name="name" type="text" required class="validate">
                                 <label for="name">Назва</label>
                             </div>
                             <div class="input-field col s12 m6">
                                 <select name="categoryId" required>
                                     <option value="" disabled selected>Оберіть Категорію</option>
                                     <c:forEach var="category" items="${categories}">
                                         <option  value="<c:out value="${category.id}"/>"><c:out value="${category.name}"/></option>
                                     </c:forEach>
                                 </select>
                             </div>
                         </div>
                         <div class="row">

                             <div class="file-field input-field col s12 m6">
                                 <div class="btn">
                                     <span>Додати</span>
                                     <input id="main-image" required type="file" name="file" size="20" />
                                 </div>
                                 <div class="file-path-wrapper">
                                     <input class="file-path validate" placeholder="Оберіть головне зображення" type="text">
                                 </div>
                             </div>
                             <div class="col s12 m6">
                                 <div class="file-field input-field">
                                     <div class="btn">
                                         <span>Додаткові зображення</span>
                                         <input name="files" type="file" multiple>
                                     </div>
                                     <div class="file-path-wrapper">
                                         <input class="file-path validate" type="text" placeholder="Оберіть ще декілька додаткових зображень">
                                     </div>
                                 </div>
                             </div>
                         </div>
                         <div class="row">
                             <div class="row">
                                 <div class="input-field col s12">
                                     <i class="material-icons prefix">mode_edit</i>
                                     <textarea required id="icon_prefix2" name="description" class="materialize-textarea"></textarea>
                                     <label for="icon_prefix2">Опис</label>
                                 </div>
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
<script>
    $(document).ready(function() {
        $('select').material_select();
    });
</script>
</html>
