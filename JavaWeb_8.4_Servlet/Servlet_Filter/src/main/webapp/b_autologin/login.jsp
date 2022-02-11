<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
    <title>会员登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>     <!-- 引入自定义css文件 style.css -->

    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>

    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }

        font {
            color: #666;
            font-size: 22px;
            font-weight: normal;
            padding-right: 17px;
        }
    </style>
</head>
<body>

<!-- 引入header.jsp -->
<jsp:include page="/b_autologin/header.jsp"></jsp:include>

<div class="container" style="width: 100%; height: 460px; background: #FF2C4C url('${pageContext.request.contextPath}/images/loginbg.jpg') no-repeat;">
    <div class="row">
        <div class="col-md-7">
            <!--<img src="./image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">-->
        </div>

        <div class="col-md-5">
            <div style="width: 440px; border: 1px solid #E7E7E7; padding: 20px 0 20px 30px; border-radius: 5px; margin-top: 60px; background: #fff;">
                <font>会员登录</font>USER LOGIN

                <%-- <div><%=request.getAttribute("loginInfo") == null ? " " : request.getAttribute("loginInfo")%></div> --%>
                <!-- <form class="form-horizontal" action="/JavaWeb/Servlet04_VerificationCodeCheck"
                    method="post"> -->

                <!-- 使用 Filter 过滤器实现自动登录功能  -->
                <span style="color: red">${loginInfo}</span>
                <form class="form-horizontal" action="${pageContext.request.contextPath }/AutoLoginServlet" method="post">
                    <%-- 用户名 --%>
                    <div class="form-group">
                        <label for="username" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
                        </div>
                    </div>

                     <%-- 密码 --%>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="inputPassword3" name="password" placeholder="请输入密码">
                        </div>
                    </div>

                    <%-- 自动登录、记住用户名--%>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label><input type="checkbox" name="autoLogin" value="autoLogin"> 自动登录</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <label> <input type="checkbox"> 记住用户名</label>
                            </div>
                        </div>
                    </div>

                    <%-- 登录按钮 --%>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <input type="submit" width="100" value="登录" name="submit" style="background: url('${pageContext.request.contextPath}/images/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 引入footer.jsp -->
<jsp:include page="/b_autologin/footer.jsp"></jsp:include>

</body>
</html>