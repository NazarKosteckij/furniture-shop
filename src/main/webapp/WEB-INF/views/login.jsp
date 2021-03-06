<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<link rel="stylesheet" href="<c:url value="/resources/css/materialize.css" />">
	<link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />">
	<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
	<script src="<c:url value="/resources/js/materialize.js"/>"></script>
	<script src="<c:url value="/resources/js/md5.js"/>"></script>
	<script src='https://www.google.com/recaptcha/api.js'></script>
	<link href="http://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet" type="text/css">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<title>Вхід</title>
</head>
<body>
<jsp:include page="navigationBar.jsp" />
<main>
	<div class="container">
	  <c:if test="${not empty param.error}">
			<font color="red"> Error
			: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
		</c:if>
		<form method="POST" id="login-form" action="<c:url value="/j_spring_security_check" />">

			<div class="input-field col s6">
				<input id="email"  type="text" name="j_username" class="validate">
				<label for="email">логін</label>
			</div>
			<div class="input-field col s6">
				<input id="password" type="password"  name="j_password"  class="validate">
				<label for="password">Пароль</label>
			</div>
				<div class="row">
				 <p>
				 <input type="checkbox" id="remember" name="_spring_security_remember_me"/>
					 <label for="remember">запам'ятати мене</label>
				 </p>
				</div>
				<%--<a class="btn" onclick="preprocessData()"> Login</a>--%>
				<input class="btn" type="submit" value="Вхід" />

		</form>
		<script type="text/javascript">
		function preprocessData(){
			$('#password').val(calcMD5($('#password').val()));
			$("#login-form").submit();
		}
		</script>
	</div>
</main>

<c:import url="footer.jsp"/>
</body>
</html>