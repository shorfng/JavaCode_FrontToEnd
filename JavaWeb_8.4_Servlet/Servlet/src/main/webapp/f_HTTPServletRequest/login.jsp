<%--
  User：蓝田_Loto
  Date：2019-01-03 19:00
  PageName：login.jsp
  Function：登录界面
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>登录界面</title>
</head>

<body>
<form action="${pageContext.request.contextPath}/c_HTTPServletRequest_getBody" method="get">
    用户名：<input type="text" name="username"><br>

    密码：<input type="password" name="password"><br>

    兴趣：<input type="checkbox" name="hobby" value="zq">足球
    <input type="checkbox" name="hobby" value="pq">排球
    <input type="checkbox" name="hobby" value="ppq">乒乓球<br>

    <input type="submit" value="提交"><br>
</form>
</body>
</html>
