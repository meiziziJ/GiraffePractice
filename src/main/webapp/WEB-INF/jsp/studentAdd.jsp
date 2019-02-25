<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function doSubmit(sid){
		var studentForm = document.getElementById("studentForm");
		if(sid){
			//修改时候执行
			<%--studentForm.action = '${pageContext.request.contextPath}/bookAction.action?methodName=update';--%>
		}else{
			//新增时候执行
            studentForm.action = '${pageContext.request.contextPath}/student/studentAdd';
		}
        studentForm.submit();
	}
</script>
</head>
<body>
</form>
	<form id="studentForm" action="" method="post" enctype="multipart/form-data">
		sid:<input type="text" name="sid"><br>
		sname:<input type="text" name="sname"><br>
		simage:<img src="${pageContext.request.contextPath}/${s.simage }" width="100" height="50">

		<input type="file" name="file"><br>
		<input type="submit" value="提交" onclick="doSubmit('${student.sid }');"><br>
	</form>
</body>
</html>