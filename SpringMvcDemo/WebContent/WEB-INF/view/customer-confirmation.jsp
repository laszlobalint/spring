<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Customer Confirmation</title>
  </head>
  <body>
    <p>The customer ${customer.firstName} ${customer.lastName} is confirmed.</p>
    <p>Free passes: ${customer.freePasses}</p>
    <p>Postal code: ${customer.postalCode}</p>
    <p>Country code: ${customer.countryCode}</p>
  </body>
</html>
