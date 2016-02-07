<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html ng-app="catalog">
<head>
	<link rel="stylesheet" href="<c:url value="/resources/css/materialize.css" />">
	<link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />">
	<script src="<c:url value="/resources/js/lib/jquery.min.js"/>" > </script>
	<script src="<c:url value="/resources/js/materialize.js"/>"> </script>
	<script src="<c:url value="/resources/js/lib/angular.min.js" /> "> </script>
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.0/angular-route.js"> </script>
	<script src="<c:url value="/resources/js/Application.js" /> "> </script>
	<link href="http://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet" type="text/css">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<title>Home</title>
	<style>
		.card-image
		{
			height: 200px;
			overflow: hidden;
		}
		.image {
			position: absolute;
			margin: auto;
			min-height: 100%;
			min-width: 100%;

			/* For the following settings we set 100%, but it can be higher if needed
            See the answer's update */
			left: -100%;
			right: -100%;
			top: -100%;
			bottom: -100%;
		}
	</style>
</head>

<body >
	<jsp:include page="navigationBar.jsp" />
	<main>

		<div ng-controller="CatalogController as catalog" class="container">
            <div class="row">
				<!-- Dropdown Trigger -->
				<div class="col s12 m7">
					<h1 class="flow-text">
						{{catalog.getCurrentCategoryName()}}
					</h1>
				</div>
				<div class="col s12 m5">
					<h5 class=" ">
						<a class="dropdown-button btn-large right waves-effect orange darken-2" href='#' data-activates='category-dropdown'><i class="material-icons large left ">list</i>Категорія</a>

						<ul id='category-dropdown' class='dropdown-content' >
								<li  class="collection-item" ng-repeat="category in catalog.categories" href ng-click="catalog.setCategory(category.id); ">
									<a class="dropdown-link" href="#?id={{category.id}}">{{category.name}}</a>
								</li>
						</ul>
					</h5>
				</div>
			</div>

			<div class="row">
				<ul id="staggered">
					<li ng-repeat="category in  catalog.categories">
					<div class="col s8 m4 offset-s2" ng-repeat="product in category.products">
						<div ng-show="catalog.categoryId === product.category_id" class="card">
							<div class="card-image waves-effect waves-block waves-light">
								<img width="300px" class=" activator" ng-src="/img/{{product.image.uri}}">
							</div>
							<div class="card-content">
								<span class="card-title activator grey-text text-darken-4">{{product.name}}<i class="material-icons right">more_vert</i></span>
								<p><a href="/products/{{product.id}}">Деталі</a></p>
							</div>
							<div class="card-reveal">
								<span class="card-title grey-text text-darken-4">{{product.name}}<i class="material-icons right">close</i></span>
								<p>{{product.description}}</p>
							</div>
						</div>
					</div>
				</li>
				</ul>
			</div>
		</div>
	</main>
	<c:import url="footer.jsp"/>
</body>
</html>
