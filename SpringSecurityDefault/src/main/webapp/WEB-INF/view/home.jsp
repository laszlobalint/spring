<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home</title>
  </head>
  <body>
    <div>
      <h2>Company Home Page</h2>
      <p>Welcome to the page <sec:authentication property="principal.username" />.</p>
      <p>Roles(s): <sec:authentication property="principal.authorities" />.</p>
      <br />
      <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout" />
      </form:form>
    </div>
    <hr />
    <sec:authorize access="hasRole('MANAGER')">
      <div>
        <a href="${pageContext.request.contextPath}/leaders">Leadership Meetings</a>
	  </div>
    </sec:authorize>
	<sec:authorize access="hasRole('ADMIN')">
      <div>
        <a href="${pageContext.request.contextPath}/systems">IT System Meetings</a>
	  </div>
    </sec:authorize>
  </body>
</html>
