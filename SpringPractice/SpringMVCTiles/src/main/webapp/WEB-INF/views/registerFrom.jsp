<%--
  Created by IntelliJ IDEA.
  User: JiaLei
  Date: 2019/8/11
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/style.css" />" >
</head>
<body>
    <h1>Register</h1>
    <sf:form method="POST" commandName="jialei.com.jialei.com.spitter">
        <sf:errors path="*" element="div" cssClass="errors"/>
        First Name: <sf:input path="firstName"/><br/>
        Last Name: <sf:input path="lastName" /><br/>
        Email: <sf:input type="email" path="email" /><br/>
        Username: <sf:input type="text" path="username" cssErrorClass="error"/><br/>
        Password: <sf:password path="password" /><br/>
        <input type="submit" value="Register" />
    </sf:form>
</body>
</html>
