<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Student Form</title>
  </head>
  <body>
    <form:form action="process-form" modelAttribute="student">
      <label>First name:</label>
      <form:input path="firstName" />
      <br />
      <label>Last name:</label>
      <form:input path="lastName" />
      <br />
      <form:select path="country">
        <form:options items="${student.countries}" />
      </form:select>
      <br />
      <label>Favorite programming language:</label>
      <form:radiobuttons path="favoriteLanguage" items="${student.languages}" />
      <br />
	  <label>Linux</label><form:checkbox path="operatingSystems" value="Linux" />
	  <label>Mac OS</label><form:checkbox path="operatingSystems" value="Mac OS" />
	  <label>Windows</label><form:checkbox path="operatingSystems" value="Windows" />
	  <br />
      <input type="submit" value="Submit" />
    </form:form>
  </body>
</html>
