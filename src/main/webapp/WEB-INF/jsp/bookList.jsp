<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="/zking" prefix="z" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function add(){
		// window.location.href = "bookEdit.jsp";
		window.location.href="${pageContext.request.contextPath}/book/pageUrl?pageUrl=bookAdd";
	}
	
	function update(bid){
		window.location.href = "${pageContext.request.contextPath}/book/pageUrl?pageUrl=bookEdit&&bid="+bid;
	}
	
	function del(bid){
		window.location.href = "${pageContext.request.contextPath}/book/del/"+bid;
	}
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/book/list"
		method="post">
		书名：<input type="text" name="book_name"> <input type="submit"
			value="确定">
	</form>
	<button onclick="add();">新增</button>
	<table border="1" width="100%">
		<tr>
			<td>编号</td>
			<td>名称</td>
			<td>价格</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${bookList}" var="b">
			<tr>
				<td>${b.book_id }</td>
				<td>${b.book_name }</td>
				<td>${b.price }</td>
				<td>
					<button onclick="update(${b.book_id });">修改</button>&nbsp;&nbsp;&nbsp;
					<button onclick="del(${b.book_id });">删除</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<z:page pageBean="${pageBean }"></z:page>
</body>
</html>