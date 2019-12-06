<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<script type="text/javascript"> var context = '${pageContext.request.contextPath}';</script>

<html>
<head>
<title>Film Recommender</title>
<!-- jQuery -->
<script type="text/javascript"
	src="<c:url value="/resources/jquery-3.2.0.min.js"/>" /></script>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<!-- Bootstrap Star Rating -->
<link href="<c:url value="/resources/style/star-rating.css"/>"
	media="all" rel="stylesheet" type="text/css" />
<script src="<c:url value="/resources/star-rating.js"/>"
	type="text/javascript"></script>
<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>
<!-- My style -->
<link rel="stylesheet"
	href="<c:url value="/resources/style/style.css"/>">
<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon"
	href="<c:url value="/resources/favicon.ico"/>" />
</head>

<body>
	<nav class="navbar navbar-inverse" style="border-radius: 0 !important;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value="/home"/>"
					style="color: #FFD700;">Film Recommender</a>
			</div>
			<ul class="nav navbar-nav">
				<!-- ADMIN menu -->
				<sec:authorize access="hasRole('ADMIN')">
					<li><a href="<c:url value="/admin/addFilm"/>">Add film</a></li>
				</sec:authorize>
				<!-- USER menu -->
				<sec:authorize access="isAuthenticated()">
					<li><a href="<c:url value="/user/allFilms"/>">All films</a></li>
					<li><a href="<c:url value="/user/notWatched"/>">Not
							watched</a></li>
					<li><a href="<c:url value="/user/myFilms"/>">My films</a></li>
					<li><a href="<c:url value="/user/topRecommended"/>">recommended</a></li>
				</sec:authorize>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<sec:authorize access="isAnonymous()">
					<li><a href="<c:url value="/registration"/>"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="<c:url value="/login"/>"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li><a href="<c:url value="/logout"/>"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				</sec:authorize>
			</ul>
		</div>
	</nav>