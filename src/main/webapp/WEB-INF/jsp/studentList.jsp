<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/zking" prefix="z" %>
<html>
<head>
    <title>学生</title>
    <script type="text/javascript">
        function add(){
            var sid = "55";
            window.location.href="${pageContext.request.contextPath}/student/pageUrl?pageUrl=studentAdd&&sid="+sid;
        }

        function update(sid){
            window.location.href = "${pageContext.request.contextPath}/student/pageUrl?pageUrl=studentEdit&&sid="+sid;
        }

        function del(sid){
            window.location.href = "${pageContext.request.contextPath}/student/studentDel/"+sid;
        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/student/studentList"
      method="post">
    书名：<input type="text" name="sname"> <input type="submit"
                                                   value="确定">
</form>
<button onclick="add();">新增</button>
<table border="1" width="100%">
    <tr>
        <td>编号</td>
        <td>名称</td>
        <td>图片</td>
    </tr>
    <c:forEach items="${studentList }" var="s">
        <tr>
            <td>${s.sid }</td>
            <td>${s.sname }</td><%--   /ssm/target/ssm/ssm/upload暴风截图2018102303462921.jpg   --%>
            <td><img src="${pageContext.request.contextPath}/${s.simage }" width="100" height="50"></td>
            <td>
                <button onclick="update(${s.sid });">修改</button>&nbsp;&nbsp;&nbsp;
                <button onclick="del(${s.sid });">删除</button>
            </td>
        </tr>
    </c:forEach>
</table>
 <z:page pageBean="${pageBean }"></z:page>
</body>
</html>
