<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Error message:</h1>
    <c:out value="${errorMessage}" />
</body>
</html>
