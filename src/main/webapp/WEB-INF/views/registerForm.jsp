<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>

<html>
<head>
    <title>Quick Looker</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />">
    <style>
        #register-box {
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
<body>
<div id="register-box">
    <sf:form class="form-inline" method="POST" commandName="user">
        <%--<sf:errors path="*" element="div" cssClass="errors"/>--%>
        <h2 class="form-heading">Register</h2>
        <div class="form-group">
            <div class="form-group col-sm-10">
                <sf:label path="firstName"
                          cssErrorClass="error ">First Name</sf:label>:
                <sf:input class="form-control" path="firstName" cssErrorClass="error form-control"/><br/>
                <sf:errors path="firstName" element="div" cssClass="errors"/>
            </div>
            <br/>
            <div class="form-group col-sm-10">
                <sf:label path="lastName"
                          cssErrorClass="error">Last Name</sf:label>:
                <sf:input class="form-control" path="lastName" cssErrorClass="error form-control"/><br/>
                <sf:errors path="lastName" element="div" cssClass="errors"/>
            </div>
            <br/>
            <div class="form-group col-sm-10">
                <sf:label path="email"
                          cssErrorClass="error">Email</sf:label>:
                <sf:input class="form-control" type="email" path="email" cssErrorClass="error form-control"/><br/>
                <sf:errors path="email" element="div" cssClass="errors"/>
            </div>
            <br/>
            <div class="form-group col-sm-10">
                <sf:label path="username"
                          cssErrorClass="error">Username</sf:label>:
                <sf:input class="form-control" path="username" cssErrorClass="error form-control"/><br/>
                <sf:errors path="username" element="div" cssClass="errors"/>
            </div>
            <br/>
            <div class="form-group col-sm-10">
                <sf:label path="password"
                          cssErrorClass="error">Password</sf:label>:
                <sf:input class="form-control" type="password" path="password" cssErrorClass="error form-control"/><br/>
                <sf:errors path="password" element="div" cssClass="errors"/>
                <br/>
                <input type="submit" class="btn btn-primary" value="Register"/>
            </div>
        </div>
    </sf:form>
</div>
</body>
</html>
