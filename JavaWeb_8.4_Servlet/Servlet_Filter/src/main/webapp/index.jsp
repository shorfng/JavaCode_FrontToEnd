<%--
  User：蓝田_Loto
  Date：2019-01-07 18:15
  PageName：index.jsp
  Function：Filter项目目录
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Filter项目目录</title>
</head>

<body>
<h3>a.usage</h3>
<a href="${pageContext.request.contextPath}/FilterServlet01">测试：Filter执行过程（转发和重定向）</a><br>

<h3>b.autologin</h3>
<a href="${pageContext.request.contextPath}/b_autologin/login.jsp">案例1：自动登录</a><br>

</body>
</html>
