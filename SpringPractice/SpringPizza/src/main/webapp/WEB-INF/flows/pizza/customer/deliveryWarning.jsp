<%--
  Created by IntelliJ IDEA.
  User: JiaLei
  Date: 2019/10/3
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Delivery Unavailable</h2>

    <p>The address is outside of our delivery area. The order
        may still be taken for carry-out.</p>
    <a href="${flowExecutionUrl}&_eventId=accept">Accept</a>
    <a href="${flowExecutionUrl}&_eventId=cancel">Cancel</a>

</body>
</html>
