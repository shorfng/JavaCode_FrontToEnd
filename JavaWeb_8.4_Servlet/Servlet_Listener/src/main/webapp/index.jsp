<%--
  User：蓝田_Loto
  Date：2019-01-02 23:06
  PageName：index.jsp
  Function：Servlet_Listener 项目目录
--%>

<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
    <title>Servlet_Listener 项目目录</title>
</head>

<body>
<h3>b.Attribute</h3>
<a href="${pageContext.request.contextPath}/Test_AttributeListenerServlet">Test_AttributeListenerServlet</a><br>

<h3>c.HttpSessionBindingListener</h3>
<a href="${pageContext.request.contextPath}/Test_HttpSessionBindingListenerServlet">Test_HttpSessionBindingListenerServlet</a><br>

<h3>d.HttpSessionActivationListener</h3>
<a href="${pageContext.request.contextPath}/TestSet_HttpSessionActivationListenerServlet">TestSet_HttpSessionActivationListenerServlet</a><br>
<a href="${pageContext.request.contextPath}/TestGet_HttpSessionActivationListenerServlet">TestGet_HttpSessionActivationListenerServlet</a><br>

</body>
</html>
