<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
  <nav class="top-nav">
    <div class="container">
      <ul id="nav-mobile" class="left">
        <li> <a href="<c:url value="/" />">Головна</a> </li>
        <li> <a href="<c:url value="/catalog" />">Каталог</a>  </li>
      </ul>
      <ul id="nav-admin" class="right">
        <li> <a href="<c:url value="/admin/categories" />">Категорії</a> </li>
        <li> <a href="<c:url value="/admin/products" />">Продукти</a>  </li>
      </ul>
    </div>
  </nav>
</header>
