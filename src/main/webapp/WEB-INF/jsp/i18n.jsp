<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/29
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/i18n">English</a>
<a href="${pageContext.request.contextPath}/i18n?state=中文">中文</a>
            <t:message code="song.songName"/> {<t:message code="song.title"/> }<br/>
    <t:message code="song.sing"/> ：<t:message code="song.lyric"/>


    <form method="post" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit">
    </form>
</body>
</html>
