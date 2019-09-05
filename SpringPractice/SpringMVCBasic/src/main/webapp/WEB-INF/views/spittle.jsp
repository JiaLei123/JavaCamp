<%--
  Created by IntelliJ IDEA.
  User: JiaLei
  Date: 2019/8/11
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
