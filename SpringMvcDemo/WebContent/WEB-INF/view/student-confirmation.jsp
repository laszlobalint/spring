<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" predix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Student Confirmation</title>
  </head>
  <body>
    <p>The student ${student.firstName} ${student.lastName} is confirmed.</p>
    <p>Country: ${student.country}</p>
    <p>Favorite programming language: ${student.favoriteLanguage}</p>
    <div>
      <ul>
        <c:forEach var="os" items="${student.operatingSystems}">
          <li>${os}</li>
        </c:forEach>
      </ul>
    </div>
  </body>
</html>
