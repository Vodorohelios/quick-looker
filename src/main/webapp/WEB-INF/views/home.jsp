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

    <s:url value="/user/users" var="usersUrl"/>
    <a href="${usersUrl}">Users</a> |

    <s:url value="/logout" var="logoutUrl" />
    <a href="${logoutUrl}">Logout</a> <br /><br />

  </body>
</html>
