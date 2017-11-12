<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<title>Login Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css"
		  href="<c:url value="/resources/style.css" />" >
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 350px;
	padding: 20px;
	margin: 100px auto;
	background: #eeeeee;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	/*border: 1px solid #000;*/
}
</style>
</head>
<%--<body onload='document.loginForm.username.focus();'>--%>
<body>

	<div id="login-box">

		<form name='loginForm' action="<c:url value='/login' />" method='POST'>
			<h2 class="form-heading">Log in</h2>
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				<input id="username" type="text" class="form-control" name='username' placeholder="Username" autofocus="true">
			</div>
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				<input id="password" type="password" class="form-control" name="password" placeholder="Password">
			</div>
			<c:if test="${param.error != null}">
				<div class="errors">
					<c:out value="Your username or password is invalid." />
				</div>
			</c:if>
			<%--<input type="submit" class="btn btn-primary" value="Register" />--%>
			<br />
			<input name="submit" type="submit" value="Log in" type="submit" class="btn btn-lg btn-primary btn-block" />
			<h4 class="text-center"><a href="<c:url value='/user/register' />">Create an account</a></h4>

			<input type="hidden" name="${_csrf.parameterName}"
				   value="${_csrf.token}" />
		</form>

		<%-- --------------------------- --%>
			<%--<c:if test="${not empty error}">--%>
			<%--<div class="error">${error}</div>--%>
			<%--</c:if>--%>
			<%--<c:if test="${not empty msg}">--%>
			<%--<div class="msg">${msg}</div>--%>
			<%--</c:if>--%>

			<%--<form name='loginForm'--%>
			<%--action="<c:url value='/login' />" method='POST'>--%>

			<%--<table>--%>
			<%--<tr>--%>
			<%--<td>User:</td>--%>
			<%--<td><input type='text' name='username' value=''></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
			<%--<td>Password:</td>--%>
			<%--<td><input type='password' name='password' /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
			<%--<td colspan='2'><input name="submit" type="submit"--%>
			<%--value="submit" /></td>--%>
			<%--<td><a href="<c:url value='/user/register' />">Register</a></td>--%>
			<%--</tr>--%>
			<%--</table>--%>

			<%--<input type="hidden" name="${_csrf.parameterName}"--%>
			<%--value="${_csrf.token}" />--%>

			<%--</form>--%>
	</div>

</body>
</html>
