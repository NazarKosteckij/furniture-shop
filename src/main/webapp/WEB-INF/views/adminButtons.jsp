<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p class="row center">
    <h1 class="flow-text">
        <b>Панель керування</b>
    </h1>
</p>
<div class="fixed-action-btn horizontal" style="bottom: 45px; right: 24px;">
    <a class="btn-floating btn-large green">
        <i class="large material-icons">add</i>
    </a>
    <ul>
        <li>
            <a class="btn-floating  blue tooltipped" data-position="left" data-delay="50" data-tooltip="Категорію" style="transform: scaleY(0.4) scaleX(0.4) translateY(40px); opacity: 0;"  href="<c:url value="/admin/categories/add"/>">
                <i class="material-icons">assignment</i>
            </a>
        </li>
        <li>
            <a class="btn-floating yellow darken-1 tooltipped" data-position="left" data-delay="50" data-tooltip="Товар" style="transform: scaleY(0.4) scaleX(0.4) translateY(40px); opacity: 0;" href="<c:url value="/admin/products/add"/>"><i class="material-icons">web</i></a>
        </li>
    </ul>
</div>
<div id="confirmation-dialog" class="modal">
    <div class="modal-content">
        <h4 id="modal-tittle">Підтвердіть вашу дію</h4>
        <p id="modal-content"></p>
    </div>
    <div class="modal-footer">
        <a href="#!" id="modal-confirm-action" class=" modal-action modal-close waves-effect waves-green btn-flat ">Так</a>
        <a href="#!" class="modal-action modal-close waves-effect waves-red btn-flat ">Ні</a>
    </div>
</div>