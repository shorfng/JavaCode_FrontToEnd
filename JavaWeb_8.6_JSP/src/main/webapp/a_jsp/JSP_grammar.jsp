<%--  page指令 --%>
<%@ page language="java" pageEncoding="UTF-8" session="true" import="java.util.*" errorPage="../a_jsp/error.jsp" isErrorPage="true" buffer="8kb" %>

<%--  taglib指令：引入JSTL核心库 --%>
<%-- <%@ taglib uri="http://xxx" prefix="abc"%> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>jsp 语法</title>
</head>

<body>
<%-- 1、JSP脚本类型 --%>
<%-- JSP脚本类型1:<%java代码%> --%>
<%
    int i = 0;
    System.out.print("i=" + i);  // i=0
%>

<%--  JSP脚本类型2:<%=java变量或表达式> --%>
<%=i%>
<%=1 + 1%>

<%--  JSP脚本类型3:<%!java代码%> --%>
<%!String str = "TD";%>

<%-- 2、指令 --%>
<%
    /* page指令：session默认为true */
    request.setAttribute("age", 30);
    session.setAttribute("name", "CJ");

    /* page指令：import导java包 */
    List list = new ArrayList();
%>

<%--  include指令:将一个jsp页面包含到另一个jsp页面中 --%>
<%@ include file="../a_jsp/error.jsp" %>

<%-- 3、JSP内置/隐式对象：out对象  向客户端输出内容 --%>
<!-- 方法1：直接输出 -->
JSP内置/隐式对象（方法1：直接输出）

<!-- 方法2：out.write -->
<%out.write("JSP内置/隐式对象（方法2：out.write）");%>

<!-- 方法3：在标签中写 -->
<%="JSP内置/隐式对象（方法3：在标签中写）"%>

<!-- 方法4：response.getWriter().write -->
<%response.getWriter().write("JSP内置/隐式对象（方法4：response.getWriter().write）");%>

<%-- 4、JSP内置/隐式对象： pageContext对象 --%>
<%
    // 使用pageContext向其他域 存数据
    request.setAttribute("name", "zhangsan");
    pageContext.setAttribute("name", "sunba");
    pageContext.setAttribute("name", "lisi", PageContext.REQUEST_SCOPE);
    pageContext.setAttribute("name", "wangwu", PageContext.SESSION_SCOPE);
    pageContext.setAttribute("name", "tianqi", PageContext.APPLICATION_SCOPE);
%>

<!-- 使用 pageContext 向其他域 取数据 -->
<%=request.getAttribute("name")%>
<%=pageContext.getAttribute("name", PageContext.REQUEST_SCOPE)%>

<!-- 使用 pageContext 的 findAttribute属性方法 会从小到大搜索域的范围中的name：pageContext域<request域<session域<application域 -->
<%=pageContext.findAttribute("name")%>

<!-- pageContext可以获得其他8大隐式对象 -->
<%
    pageContext.getRequest();
    pageContext.getOut();

    //method(pageContext);
%>
</body>
</html>