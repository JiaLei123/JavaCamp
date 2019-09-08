<%--
  Created by IntelliJ IDEA.
  User: JiaLei
  Date: 2019/7/31
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
</head>
<body>
<h1>Welcome to Spittr</h1>
<a href="<c:url value="/spittles"/>">Spittles</a>
<a href="<c:url value="/spitter/register"/>">Register</a>
<a href="<c:url value="/spitter/registerNew"/>">RegisterNew</a>
</body>
</html>
