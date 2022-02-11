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
 * PageName：b_GetCookie.java
 * Function：获取Cookie（服务器端接受客户端携带的Cookie）
 */

public class b_GetCookie extends HttpServlet {
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

        response.getWriter().write("获取Cookie...");

        // 1、通过 request，获得客户端携带的所有 cookie 数据
        Cookie[] cookies = request.getCookies();

        // 2、遍历Cookie数组，通过Cookie的名称获得想要的Cookie
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // 获得cookie的键
                String cookieName = cookie.getName();
                System.out.println("cookie的键：" + cookieName);

                // 获得该cookie的值
                String cookieValue = cookie.getValue();
                System.out.println("cookie的值：" + cookieValue);
                System.out.println("=======================================================");
            }
        }
    }

}
