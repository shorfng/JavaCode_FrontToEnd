<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- 使用jsp的taglib指令导入核心标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSTL标签语法</title>
</head>

<body>
<%request.setAttribute("count", 10);%>

<!-- 1、if标签 -->
<!-- test代表的返回boolean的表达式 -->
<c:if test="1==1"></c:if>

<!-- JSTL标签与EL表达式混用 -->
<c:if test="${count==9 }">
    xxxx
</c:if>

<!-- 开发中的使用 -->
<!-- 用户没有登录 -->
<c:if test="${empty user}">
    <li><a href="login.jsp">登录</a></li>
    <li><a href="register.jsp">注册</a></li>
</c:if>
<!-- 用户已经登录 -->
<c:if test="${!empty user}">
    <li>${user.name }</li>
    <!-- 显示用户名 -->
    <li><a href="#">退出</a></li>
</c:if>

<hr>

<!-- 2、forEach标签  -->
<!-- 类型1：普通for -->
<!--
    for(int i=0;i<=5;i++){
        syso(i)；
    }
-->
<c:forEach begin="0" end="5" var="i">
    ${i }<br/>
</c:forEach>

<!-- 类型2：增强for  -->
<!--
    for(Product pro : productList){
        syso(pro.getPname());
    }
 -->
<!-- items:一个集合或数组   var:代表集合中的某一个元素 -->
<c:forEach items="${productList }" var="pro">
    ${pro.pname }
</c:forEach>
</body>
</html>