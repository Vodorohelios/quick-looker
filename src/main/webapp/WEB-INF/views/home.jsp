<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<html>
  <head>
    <title>Quick Looker</title>
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1><s:message code="quicklooker.welcome" text="Welcome" /></h1>
    <s:url value="/user/register" var="registerUrl" />
    <a href="${registerUrl}">Register</a> <br /><br />
    <table border="1">
        <tr>
            <th>username</th>
            <th>first name</th>
            <th>last name</th>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="status">
            <tr>
                <td><a href="<s:url value="/user/${user.username}" />">
                    ${user.username}
                </a></td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
            </tr>
        </c:forEach>
    </table>
  </body>
</html>
