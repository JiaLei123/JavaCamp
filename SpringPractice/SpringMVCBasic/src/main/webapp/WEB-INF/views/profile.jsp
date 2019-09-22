<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>Your Profile</h1>
    <c:out value="${jialei.com.jialei.com.spitter.username}" /><br/>
    <c:out value="${jialei.com.jialei.com.spitter.firstName}" /> <c:out value="${jialei.com.jialei.com.spitter.lastName}" /><br/>
    <c:out value="${jialei.com.jialei.com.spitter.email}" />
</body>
</html>
