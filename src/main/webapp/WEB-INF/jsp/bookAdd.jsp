<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function doSubmit(bid){
		var bookForm = document.getElementById("bookForm");
		if(bid){
			//修改时候执行
			<%--bookForm.action = '${pageContext.request.contextPath}/bookAction.action?methodName=update';--%>
		}else{
			//新增时候执行
			bookForm.action = '${pageContext.request.contextPath}/book/add';
		}
		bookForm.submit();
	}
</script>
</head>
<body>
	<form id="bookForm" action="" method="post">
		bid:<input type="text" name="book_id"><br>
		bname:<input type="text" name="book_name"><br>
		price:<input type="text" name="price"><br>
		<input type="submit" value="提交" onclick="doSubmit('${book.book_id }');"><br>
	</form>
</body>
</html>