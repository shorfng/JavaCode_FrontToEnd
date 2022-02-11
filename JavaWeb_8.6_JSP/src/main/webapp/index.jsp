<%--
  User：蓝田_Loto
  Date：2019-01-07 20:34
  PageName：index.jsp
  Function：jsp项目目录
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>jsp项目目录</title>
</head>

<body>
<h3>a.jsp</h3>
<a href="${pageContext.request.contextPath}/a_jsp/JSP_grammar.jsp">jsp使用</a><br>

<h3>b.EL表达式</h3>
<a href="${pageContext.request.contextPath}/b_el/EL_grammer.jsp">EL表达式使用</a><br>

<h3>c.JSTL标签</h3>
<a href="${pageContext.request.contextPath}/c_jstl/JSTL_grammer.jsp">JSTL标签使用</a><br>
</body>
</html>
