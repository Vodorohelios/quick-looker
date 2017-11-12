<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Quick Looker</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />">

    <script type="text/javascript">
        function deletePost(username, elementId, postId) {
            var xhttp;
            xhttp = new XMLHttpRequest();
            xhttp.open("GET", "/posts/delete/" + postId + "?username=" + username, true);
            xhttp.send();

            var element = document.getElementById(elementId);
            element.parentNode.removeChild(element);
        }
    </script>
</head>
<body>
<div class="container">
<h1>${user.username} Profile</h1>
<c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/><br/>
<c:out value="${user.email}"/>

<hr/>
<a href="<s:url value="/" />">Main Page</a> <br/>
<security:authorize access="isAuthenticated() and principal.username == '${user.username}'">
    <br />
    <div>
        <h1>Write new post</h1>
        <s:url value="/posts/create" var="createUrl"/>
        <sf:form method="POST" name="postForm" modelAttribute="postForm" action="${createUrl}"
                 class="form-group row">
            <sf:input type="hidden" path="username" value="${user.username}"/>
        <div>
            <label>Title:<label> <br/>
            <sf:input type="text" path="title"/> <br/>
        </div>
            <label>Message:</label> <br/>
            <sf:textarea path="message" cols="80" rows="5"/><br/><br />
            <div class="col-xs-2">
                <input type="submit" value="Post" class="form-control input-sm"/>
            </div>
        </sf:form>
    </div>
</security:authorize>
<hr/>

<h2>Posts</h2>
<ul class="userList">
    <c:forEach items="${user.posts}" var="post" varStatus="status">
        <div>
        <div id="row-${status.count}">
            <li id="post_<c:out value="post.id"/>">
                <h3 class="postTitle">
                    <c:out value="${post.title}"/>
                </h3>
                <h4 class="postAuthor"><c:out value="${post.author.username}"/></h4>
                <div class="postMessage"><c:out value="${post.body}"/></div>
                <br/>
                <div>
                    <span class="postDate"><c:out value="${post.date}"/></span>
                    <security:authorize access="isAuthenticated() and principal.username == '${user.username}'">
                        <small>
                            <button type="button" class="btn btn" class="" type="button" style="cursor: pointer;"
                                    onclick="javascript:deletePost('${user.username}', 'row-${status.count}', ${post.id})">Delete</button>
                        </small>
                    </security:authorize>
                </div>
            </li>
            <hr/>
        </div>
        </div>
    </c:forEach>
</ul>

    <div>
        <s:url value="/user/delete/${user.username}" var="deleteUrl" />
        <form method="post" action="${deleteUrl}" class="form-inline form-group row">
            <div class="form-group">
                <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                <input type="submit" value="Delete this profile" class="form-control input-sm" />
            </div>
        </form>
    </div>
</div>
</body>
</html>
