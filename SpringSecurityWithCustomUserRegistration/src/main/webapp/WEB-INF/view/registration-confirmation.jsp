<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Registration Confirmation</title>
  </head>
  <body>
    <h2>User registered successfully!</h2>
    <hr />
    <a href="${pageContext.request.contextPath}/login">Login with new user</a>
  </body>
</html>
