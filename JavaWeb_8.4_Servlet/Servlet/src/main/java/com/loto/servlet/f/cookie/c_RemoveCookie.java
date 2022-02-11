package com.loto.servlet.f.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author：蓝田_Loto
 * Date：2019-01-04 15:02
 * PageName：c_RemoveCookie.java
 * Function：删除客户端的Cookie（使用同名同路径的持久化时间为0的Cookie进行覆盖即可）
 */

public class c_RemoveCookie extends HttpServlet {
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

        response.getWriter().write("删除客户端的Cookie...");

        // 1、删除客户端保存 name=TD 的cookie信息
        Cookie cookie = new Cookie("name", "");

        // 2、将path设置成与要删除cookie的path一致
        cookie.setPath("/JavaWeb_4_3_04_Servlet_war_exploded");

        // 3、设置持久化时间是0
        cookie.setMaxAge(0);

        // 4、将cookie中存储的信息发送到客户端（以响应头的形式）
        response.addCookie(cookie);


        //======================= 验证是否删除 =====================================================

        // 通过 request，获得客户端携带的所有 cookie 数据
        Cookie[] cookies1 = request.getCookies();

        // 遍历Cookie数组，通过Cookie的名称获得想要的Cookie
        if (cookies1 != null) {
            for (Cookie cookie2 : cookies1) {
                // 获得cookie的键
                String cookieName = cookie2.getName();
                System.out.println("cookie的键：" + cookieName);

                // 获得该cookie的值
                String cookieValue = cookie2.getValue();
                System.out.println("cookie的值：" + cookieValue);
                System.out.println("=======================================================");
            }
        }
    }
}
