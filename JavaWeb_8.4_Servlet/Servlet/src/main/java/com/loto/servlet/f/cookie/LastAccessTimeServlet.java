package com.loto.servlet.f.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author：蓝田_Loto
 * Date：2019-01-04 15:37
 * PageName：LastAccessTimeServlet.java
 * Function：显示用户上次访问的时间
 */

public class LastAccessTimeServlet extends HttpServlet {
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

        // 0、获得当前时间"yyyy-MM-dd KK:mm aa"
        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());   // 24小时制

        // 1、创建Cookie，记录当前最新的访问时间
        Cookie cookie = new Cookie("lastAccessTime", currentTime);
        cookie.setMaxAge(10 * 60 * 500);  // 10分钟x500
        response.addCookie(cookie);

        // 2、获得客户端携带的cookie
        String lastAccessTime = null;
        Cookie[] cookies = request.getCookies();

        // 遍历客户端所有携带的cookie，找到 lastAccessTime 这个cookie
        if (cookies != null) {
            for (Cookie coo : cookies) {
                if ("lastAccessTime".equals(coo.getName())) {
                    lastAccessTime = coo.getValue();
                }
            }
        }

        // 3、判断访问时间
        if (lastAccessTime == null) {
            response.getWriter().write("您是第一次访问");
        } else {
            response.getWriter().write("您上次的访问的时间是：" + lastAccessTime);
        }
    }
}