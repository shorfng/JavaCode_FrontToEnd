<%--
  User：蓝田_Loto
  Date：2019-01-03 16:14
  PageName：register.jsp
  Function：用户注册页面
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户注册</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css"/>
    <link rel="stylesheet" href="../css/style.css" type="text/css"/>     <!-- 引入自定义css文件 style.css -->

    <script src="../js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="../js/bootstrap.min.js" type="text/javascript"></script>

    <script type="text/javascript">
        window.onload = function () {
        }

        /* 效果：点击图片，刷新验证码 */
        /* 原理：每次点击访问的src地址都在变（用时间），所以每次的地址都是不一样的 */
        function changeImg(obj) {
            obj.src = "${pageContext.request.contextPath}/VerificationCode?time=" + new Date().getTime();
        }
    </script>
</head>

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
        color: #3164af;
        font-size: 18px;
        font-weight: normal;
        padding: 0 10px;
    }
</style>
</head>
<body>

<!-- 引入header.jsp -->
<jsp:include page="/g_example/header.jsp"></jsp:include>

<div class="container" style="width: 100%; background: url('../images/regist_bg.jpg');">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8" style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
            <font>会员注册</font>USER REGISTER

            <div>
                <%=request.getAttribute("loginInfo") == null ? " " : request.getAttribute("loginInfo")%>
            </div>

            <form class="form-horizontal" style="margin-top: 5px;" action="${pageContext.request.contextPath}/RegisterServlet" method="post">
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="inputPassword3" name="password" placeholder="请输入密码">
                    </div>
                </div>

                <div class="form-group">
                    <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="confirmpwd" placeholder="请输入确认密码">
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-6">
                        <input type="email" class="form-control" id="inputEmail3" name="email" placeholder="Email">
                    </div>
                </div>

                <div class="form-group">
                    <label for="usercaption" class="col-sm-2 control-label">姓名</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="usercaption" name="name" placeholder="请输入姓名">
                    </div>
                </div>

                <div class="form-group opt">
                    <label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-6">
                        <label class="radio-inline">
                            <input type="radio" name="sex" id="inlineRadio1" value="male"> 男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="sex" id="inlineRadio2" value="female"> 女
                        </label>
                    </div>
                </div>

                <div class="form-group">
                    <label for="date" class="col-sm-2 control-label">出生日期</label>
                    <div class="col-sm-6">
                        <input type="date" class="form-control" name="birthday">
                    </div>
                </div>

                <div class="form-group">
                    <label for="date" class="col-sm-2 control-label">验证码</label>
                    <div class="col-sm-3">
                        <input type="text" name="checkCode" class="form-control">
                    </div>

                    <div class="col-sm-2">
                        <img onclick="changeImg(this)" src="${pageContext.request.contextPath}/VerificationCode"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" width="100" value="注册" name="submit" style="background: url('../images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
                    </div>
                </div>
            </form>
        </div>

        <div class="col-md-2"></div>
    </div>
</div>

<!-- 引入footer.jsp -->
<jsp:include page="/g_example/footer.jsp"></jsp:include>
</body>
</html>




