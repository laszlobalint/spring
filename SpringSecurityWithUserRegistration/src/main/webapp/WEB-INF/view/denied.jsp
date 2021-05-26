<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Access Denied</title>
  </head>
  <body>
    <div>
        <h2>You are not authorized to access this resource!</h2>
      <hr />
      <div>
        <a href="${pageContext.request.contextPath}/">Back to Home Page</a>
	  </div>
	</div>
  </body>
</html>
