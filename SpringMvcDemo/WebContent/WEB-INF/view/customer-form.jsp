<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css" />
    <title>Customer Registration Form</title>
  </head>
  <body>
    <form:form action="process-form" modelAttribute="customer">
      <label>First name:</label>
      <form:input path="firstName" />
      <br />
      <label>Last name (*):</label>
      <form:input path="lastName" />
      <form:errors path="lastName" cssClass="error" />
      <br />
      <label>Free passes (*):</label>
      <form:input path="freePasses" />
      <form:errors path="freePasses" cssClass="error" />
      <br />
      <label>Postal code:</label>
      <form:input path="postalCode" />
      <form:errors path="postalCode" cssClass="error" />
      <br />
      <label>Country code:</label>
      <form:input path="countryCode" />
      <form:errors path="countryCode" cssClass="error" />
      <br />
      <input type="submit" value="Submit">
    </form:form>
  </body>
</html>
