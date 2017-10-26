<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Spitter</title>
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1><s:message code="quicklooker.welcome" text="Welcome" /></h1>
    <table border="1">
        <tr>
            <th>username</th>
            <th>first name</th>
            <th>last name</th>
            <th>email</th>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="status">
            <tr>
                <td>${user.username}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
    </table>
    <br />
    <table border="1">
            <tr>
                <th>id</th>
                <th>author</th>
                <th>title</th>
                <th>content</th>
                <th>date</th>
            </tr>
            <c:forEach items="${posts}" var="post" varStatus="status">
                <tr>
                    <td>${post.id}</td>
                    <td>${post.author.username}</td>
                    <td>${post.title}</td>
                    <td>${post.body}</td>
                    <td>${post.date}</td>
                </tr>
            </c:forEach>
        </table>
  </body>
</html>
