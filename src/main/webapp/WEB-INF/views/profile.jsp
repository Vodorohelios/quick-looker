<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Quick Looker</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>Your Profile</h1>
    <c:out value="${user.username}" /><br/>
    <c:out value="${user.firstName}" /> <c:out value="${user.lastName}" /><br/>
    <c:out value="${user.email}" />

    <hr />
    <a href="<s:url value="/" />">Main Page</a> <br />
    <div class="spittleForm">
          <h1>Write new post</h1>
          <s:url value="/posts/create" var="createUrl" />
          <sf:form method="POST" name="postForm" modelAttribute="postForm" action="${createUrl}">
            <sf:input type="hidden" path="username" value="${user.username}" />
            <label>Title:<label> <br />
            <sf:input type="text" path="title" /> <br />
            <label>Message:</label> <br />
            <sf:textarea path="message" cols="80" rows="5" /><br/>
            <input type="submit" value="Post" />
          </sf:form>
        </div>
    <hr />

    <h2>Posts</h2>
    <ul class="userList">
        <c:forEach items="${user.posts}" var="post" >
          <li id="post_<c:out value="post.id"/>">
            <h3 class="postTitle">
                <c:out value="${post.title}" />
            </h3>
            <h4 class="postAuthor"><c:out value="${post.author.username}" /></h4>
            <div class="postMessage"><c:out value="${post.body}" /></div>
            <br />
            <div>
              <span class="postDate"><c:out value="${post.date}" /></span>
              <small>
                <a href="<s:url value="/posts/delete/${post.id}?username=${user.username}" />">[Delete]</a>
              </small>
            </div>
          </li>
          <hr />
        </c:forEach>
    </ul>
  </body>
</html>
