package com.loto.servlet.g.session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Author：蓝田_Loto
 * Date：2019-01-04 16:29
 * PageName：a_GetSession.java
 * Function：获得属于本客户端的session对象
 */

public class a_GetSession extends HttpServlet {
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

        // 1、创建属于该客户端/会话的私有session区域
        HttpSession session = request.getSession();

        // 2、该session对象的编号id
        String id = session.getId();

        // 3、创建一个存储JSESSIONID的Cookie -> 持久化jsessionID
        Cookie cookie = new Cookie("JSESSIONID", id);
        cookie.setPath("/JavaWeb_4.3_04_Servlet/");
        cookie.setMaxAge(60 * 10); // 为Cookie设置持久化时间
        response.addCookie(cookie);

        response.getWriter().write("JSESSIONID:" + id);
    }
}