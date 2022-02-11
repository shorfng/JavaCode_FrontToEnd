<%--
  User：蓝田_Loto
  Date：2019-01-03 16:12
  PageName：download.jsp
  Function：文件下载页面
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>文件下载页面</title>
</head>

<body>
<h1>使用a标签直接指向服务器上的资源</h1>
<a href="${pageContext.request.contextPath}/download/TD.jpg">TD.jpg</a><br>
<a href="${pageContext.request.contextPath}/download/TD.txt">TD.txt</a><br>
<a href="${pageContext.request.contextPath}/download/TD.zip">TD.zip</a><br>

<h1>使用服务器端编码的方式实现文件下载（英文文件下载）</h1>
<a href="${pageContext.request.contextPath}/DownloadFile_EN?filename=TD.jpg">TD.jpg</a><br>
<a href="${pageContext.request.contextPath}/DownloadFile_EN?filename=TD.txt">TD.txt</a><br>
<a href="${pageContext.request.contextPath}/DownloadFile_EN?filename=TD.zip">TD.zip</a><br>

<h1>使用服务器端编码的方式实现文件下载（中文文件下载）</h1>
<a href="${pageContext.request.contextPath}/DownloadFile_CN?filename=图片.jpg">图片.jpg</a><br>
</body>
</html>
