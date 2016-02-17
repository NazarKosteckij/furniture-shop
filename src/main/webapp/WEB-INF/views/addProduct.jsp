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
    <title>Admin Panel | ${product == null ? "Додати" : "Редагувати"} товар</title>
</head>
<body>
         <jsp:include page="adminNavigationBar.jsp" />
         <main>
         <div class="container">

             <div class="row">
                 <p/>
                 <% boolean isEditing = pageContext.findAttribute("product")!=null;
                     if (isEditing) { %>
                 <div class="col s12 m4">
                     <div class="materialbox">
                         <div class="row">
                             <div class="col s8 m6 offset-s2 offset-m3">
                                 <img class="materialboxed responsive-img" src='<c:url value="/"/>img/${product.image.uri}'>
                             </div>
                         </div>
                     </div>
                 </div>
                 <% } %>
                 <div class="input-field <% if (isEditing) { %> col s12 m8 <% } %>">
                     <form method="post" enctype="multipart/form-data">
                         <div class="row">
                             <div class="input-field col s12 m6">
                                 <input value="${product.name}" id="name" name="name" type="text"  required class="validate">
                                 <label for="name">Назва</label>
                             </div>
                             <div class="input-field col s12 m6">
                                 <select required name="categoryId" >
                                     <option value="" disabled selected>Оберіть Категорію</option>
                                     <c:forEach var="category" items="${categories}">
                                         <option <c:if test="${category.id == product.category_id}">selected</c:if> value="<c:out value="${category.id}"/>"><c:out value="${category.name}"/></option>
                                     </c:forEach>
                                 </select>
                             </div>
                         </div>

                         <div class="row">
                             <div class="row">
                                 <div class="input-field col s12">
                                     <i class="material-icons prefix">mode_edit</i>
                                     <textarea required id="icon_prefix2" name="description" class="materialize-textarea">${product.description} </textarea>
                                     <label for="icon_prefix2">Опис</label>
                                 </div>
                             </div>
                         </div>
                         <div class="row">
                             <div class="file-field input-field col s12  ${product == null ? "m6" : ""}">
                                 <div class="btn waves-effect orange">
                                     <span>Додати</span>
                                     <input  accept=".jpg,.bmp" id="main-image" <c:if test="${product == null}">required</c:if>  type="file" name="file" size="20" />
                                 </div>
                                 <div class="file-path-wrapper">
                                     <input class="file-path validate" placeholder="Оберіть головне зображення" type="text">
                                 </div>
                             </div>
                             <div class="col s12 ${product == null ? "m6" : ""}">
                                 <div class="file-field input-field">
                                     <div class="btn waves-effect orange">
                                         <span>Додаткові зображення</span>
                                         <input name="files" accept=".jpg,.bmp" type="file" multiple>
                                     </div>
                                     <div class="file-path-wrapper">
                                         <input class="file-path validate" type="text" placeholder="Оберіть ще декілька додаткових зображень">
                                     </div>
                                 </div>
                             </div>
                         </div>

                         <div class="input-field">
                             <input class="btn  btn-large green darken-1" type="submit" value=" ${product == null ? "Додати" : "Редагувати"}"/>
                         </div>
                     </form>
                 </div>

             </div>
             <div id="admin-action">
                     <%--<jsp:include page="adminButtons.jsp"/>--%>
                 </div>
         </div>
    </main>

         <c:import url="footer.jsp"/>
</body>
<script>
    $(document).ready(function() {
        $('select').material_select();
        $('.materialboxed').materialbox();
    });
</script>
</html>
