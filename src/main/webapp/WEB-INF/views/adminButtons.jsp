<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nazar
  Date: 16.01.2016
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="input-field">
    <div class="row">
        <div class="col s12 m6" style="margin-bottom: 10px">
            <a class=" btn-large" href="<c:url value="/admin/categories/add"/>">Додати категорію</a>
        </div>
        <div class="col s12 m6">
            <a class=" btn-large" href="<c:url value="/admin/products/add"/>">Додати товар</a>
        </div>
    </div>
</div>
