<%--
  User：蓝田_Loto
  Date：2019-01-03 16:14
  PageName：login.jsp
  Function：用户登录页面
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>用户登录页面</title>

    <script type="text/javascript">
        window.onload = function(){}
        /* 效果：点击图片，刷新验证码 */
        /* 原理：每次点击访问的src地址都在变（用时间），所以每次的地址都是不一样的 */
        function changeImg(obj) {
            obj.src = "${pageContext.request.contextPath}/VerificationCode?time=" + new Date().getTime();
        }
    </script>
</head>

<body>
<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
    用户名：<input type="text" name="username"><br />

    密码：<input type="password" name="password"><br />

    验证码：<input type="text" name="username">
    <img onclick="changeImg(this)" src="${pageContext.request.contextPath}/VerificationCode"><br/>

    <input type="submit"value="登录"><br />
</form>
</body>
</html>
