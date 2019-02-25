<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>七牛云示例</title>
</head>
<body>          <%--   当需要使用到云服务器上的图片时，我们可将域名+图片名添加到数据库 --%>
<%--<img src="http://pn96h3wrb.bkt.clouddn.com/2019/02/25/774717f2-52eb-45e7-9ef9-940a3952acf3.jpg" width="60px" height="100px">--%>
<input type="file" id="upload" name="imagefile" />
<input type="button" value="上传" onclick="return ajaxFileUploadImage();"/><br>
<div id="imgurl">
</div>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/global.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ajaxfileupload.js"></script>
<script type="text/javascript" language="JavaScript" >
    //图片上传
    function ajaxFileUploadImage() {

        $.ajaxFileUpload({
            url: "<%=request.getContextPath()%>/qiniuUpload",//用于文件上传的服务器端请求地址
            secureuri: false,//一般设置为false
            fileElementId: 'upload',//文件上传控件的id属性  <input type="file" id="upload" name="upload" />
            dataType: 'text',//返回值类型 一般设置为json
            success: function (data)  //服务器成功响应处理函数
            {
                //var index = data.indexOf("com/");
                //var fileName = data.substring(index + 4);
               // var fileName = data.sub(index + 1); //获取上传至七牛云的图片名
               console.log("文件名：" + fileName);
//                $("#imageUrl").html(data);
                var img = "<img src="+data+">"
                //var btn = "<a href='<%=request.getContextPath()%>/qiniuDownload?fileName="+fileName+"'>下载图片</a>";
                var html = "<br><span>"+img+"&nbsp;&nbsp;&nbsp;"+btn+"</span>";
                $("#imgurl").append(html);
            }
        });
        return false;
    }
</script>

</body>
</html>
