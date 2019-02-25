<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/18
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传到图片云服务器</title>
</head>
<body>

    <!-- 自定义变量
        应用客户端在上传请求中设定自定义变量的值。七牛云存储收到这些变量信息后，置换掉ReturnBody和callbackBody中的自定义变量设置，
        形成最终的反馈结果。 自定义变量的行为同魔法变量基本一致，但变量名必须以x:开始。下面是一个自定义变量的示例 -->

    <!-- 表单元素解释：  action填写的是你的七牛云创建的存储空间所属的存储区域  -->
    <form method="post" action="http://upload.qiniup.com/" enctype="multipart/form-data">
        <input name="key" type="hidden" value="<resource_key>">
        <input name="x:location" type="hidden" value="changsha">
        <input name="token" type="hidden" value="<upload_token>">
        <input name="crc32" type="hidden" />
        <input name="accept" type="hidden" />
        <input name="file" type="file" />
        <input type="submit" value="上传文件" />
    </form>

</body>
</html>
