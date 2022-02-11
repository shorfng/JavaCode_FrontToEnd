package com.loto.servlet.f.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author：蓝田_Loto
 * Date：2019-01-04 15:01
 * PageName：a_SendCookie.java
 * Function：发送Cookie（服务器端将一个Cookie发送到客户端）
 */

public class a_SendCookie extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("调用doPost方法...");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置response的编码，并指定浏览器解析页面时的编码
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().write("发送Cookie...");

        // 1、创建Cookie对象（Cookie中不能存储中文）
        Cookie cookie = new Cookie("name", "TD");

        // 2、为cookie设置持久化时间（Cookie信息在硬盘上保存的时间）
        cookie.setMaxAge(10 * 60); // 10分钟

        // 3、 为Cookie设置携带的路径
        // 访问服务器下的所有的资源都携带这个cookie
        // cookie.setPath("/");

        // 访问 JavaWeb_4.3_04_Servlet 项目下的任何资源时都携带这个cookie
        cookie.setPath("/JavaWeb_4_3_04_Servlet_war_exploded");

        // 访问 a_SendCookie 资源时才携带这个cookie
        // cookie.setPath("/JavaWeb/a_SendCookie");

        // 4、将cookie中存储的信息发送到客户端（以响应头的形式）
        response.addCookie(cookie);
    }
}