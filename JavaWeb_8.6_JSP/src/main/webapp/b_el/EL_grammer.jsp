<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.loto.jsp.User" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>EL表达式语法</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
<!-- 模拟域中的数据 -->
<%
    // （1）存储字符串
    pageContext.setAttribute("company", "pageContext域中的数据");
    request.setAttribute("company", "request域中的数据");

    // （2）存储一个对象
    User user = new User();
    user.setId(1);
    user.setName("shorfng");
    user.setPassword("123");
    session.setAttribute("user", user);

    // （3）存储一个集合
    List<User> list = new ArrayList<User>();

    User user1 = new User();
    user1.setId(2);
    user1.setName("TD");
    user1.setPassword("123");
    list.add(user1);

    User user2 = new User();
    user2.setId(3);
    user2.setName("CJ");
    user2.setPassword("123");
    list.add(user2);

    // 把集合放在application域中
    application.setAttribute("list", list);
%>


<!-- 1、获得域中的值：脚本方式 -->
<%=request.getAttribute("company")%>
<%
    User sessionUser = (User) session.getAttribute("user");
    out.write(sessionUser.getName());
%>

<hr>

<!-- 2、获得域中的值：EL表达式 -->
${requestScope.company }<br>
${sessionScope.user.name }<br>
${applicationScope.list[1].name}<br>

<hr>

<!-- EL获得四大域中的某个值：全域查找 -->
${company }<br>
${user.name }<br>
${list[1].name}<br>

<hr>

<!--EL的内置对象使用 -->
${header["User-Agent"] }<br>
${initParam.aaa }<br>
${cookie.name.value }<br>
${pageContext.request }<br>  <!-- 获得request对象 -->

<hr>

<!-- EL执行表达式 -->
${1+1 }<br>
${1==1?true:false }<br>
${empty list}<br>  <!-- empty关键字：判定某个对象是否是null  是null返回true -->
</body>
</html>