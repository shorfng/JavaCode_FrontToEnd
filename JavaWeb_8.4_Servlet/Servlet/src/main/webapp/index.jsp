<%--
  User：蓝田_Loto
  Date：2019-01-02 23:06
  PageName：index.jsp
  Function：Servlet项目目录
--%>

<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
    <title>Servlet项目目录</title>
</head>

<body>
<h3>a.Servlet</h3>
<a href="${pageContext.request.contextPath}/a_Servlet_use">a_Servlet_use</a><br>
<a href="${pageContext.request.contextPath}/a_Servlet/index.html">SuccessServlet</a><br>

<h3>b.servletContext</h3>
<a href="${pageContext.request.contextPath}/a_ServletContext_use">a_ServletContext_use</a><br>
<a href="${pageContext.request.contextPath}/b_ServletContext_set">b_ServletContext_set</a><br>
<a href="${pageContext.request.contextPath}/c_ServletContext_get">c_ServletContext_get</a><br>

<h3>c.example</h3>
<a href="${pageContext.request.contextPath}/c_example/login.jsp">案例1：用户登录验证</a><br>

<h3>d.HTTPServletResponse</h3>
<a href="${pageContext.request.contextPath}/a_HTTPServletResponse_setStatus">HTTPServletResponse_设置HTTP的响应行</a><br>
<a href="${pageContext.request.contextPath}/b_HTTPServletResponse_setHeader">HTTPServletResponse_设置HTTP的响应头</a><br>
<a href="${pageContext.request.contextPath}/c_HTTPServletResponse_setBody">HTTPServletResponse_设置HTTP的响应体</a><br>

<h3>e.example</h3>
<a href="${pageContext.request.contextPath}/e_example/download.jsp">文件下载</a><br>
<a href="${pageContext.request.contextPath}/e_example/login.jsp">验证码功能</a><br>

<h3>f.HTTPServletRequest</h3>
<a href="${pageContext.request.contextPath}/a_HTTPServletRequest_getLine">a_HTTPServletRequest_getLine</a><br>
<a href="${pageContext.request.contextPath}/b_HTTPServletRequest_getHeader">b_HTTPServletRequest_getHeader</a><br>
<a href="${pageContext.request.contextPath}/f_HTTPServletRequest/login.jsp">c_HTTPServletRequest_getBody</a><br>
<a href="${pageContext.request.contextPath}/d_HTTPServletRequest_set">请求转发</a><br>

<h3>g.example</h3>
<a href="${pageContext.request.contextPath}/g_example/register.jsp">用户注册</a><br>
<a href="${pageContext.request.contextPath}/g_example/login.jsp">用户登录失败的信息回显</a><br>

<h3>h.cookie</h3>
<a href="${pageContext.request.contextPath}/a_SendCookie">发送Cookie</a><br>
<a href="${pageContext.request.contextPath}/b_GetCookie">获取Cookie</a><br>
<a href="${pageContext.request.contextPath}/c_RemoveCookie">删除客户端的Cookie</a><br>
<a href="${pageContext.request.contextPath}/LastAccessTimeServlet">显示用户上次访问的时间</a><br>

<h3>i.session</h3>
<a href="${pageContext.request.contextPath}/a_GetSession">获得属于本客户端的session对象</a><br>
<a href="${pageContext.request.contextPath}/b_SaveToSession">向session中存数据</a><br>
<a href="${pageContext.request.contextPath}/c_GetFromSession">向session中取数据</a><br>
<a href="${pageContext.request.contextPath}/LastAccessTimeServlet">显示用户上次访问的时间</a><br>

</body>
</html>
