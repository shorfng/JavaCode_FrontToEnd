<%--
  User：蓝田_Loto
  Date：2019-01-03 14:57
  PageName：login.jsp
  Function：登录页面
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>登录页面</title>
</head>

<body>
<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
    用户名：<input type="text" name="username"><br/>
    密码：<input type="password" name="password"><br/>

    <input type="submit" value="登录"><br/>
</form>
</body>
</html>
