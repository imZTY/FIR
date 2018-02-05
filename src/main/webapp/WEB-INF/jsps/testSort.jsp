<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/3
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<%@include file="common/head.jsp" %>
<html>
<head>
    <title>测试排行榜页面</title>
</head>
<body>
<c:forEach var="user" items="${firGameUserList}">
    <a>
        ${user.userName}
    </a>
    <span> ${user.winTimes}</span><br>
</c:forEach>
</body>
</html>
