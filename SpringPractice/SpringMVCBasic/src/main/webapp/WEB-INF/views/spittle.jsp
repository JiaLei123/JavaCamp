<%--
  Created by IntelliJ IDEA.
  User: JiaLei
  Date: 2019/8/11
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
    <div class="spittleView">
        <div class="spittleMessage"><c:out value="${spittle.message}"/></div>
        <div>
            <span class="spittleItem"><c:out value="${spittle.time}"/></span>
        </div>
    </div>

</body>
</html>
