package com.loto.servlet.d1.httpservletresponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Author：蓝田_Loto
 * Date：2019-01-03 15:32
 * PageName：b_HTTPServletResponse_setHeader.java
 * Function：通过 HTTPServletResponse 设置HTTP的响应头
 */

public class b_HTTPServletResponse_setHeader extends HttpServlet {
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

        response.getWriter().write("调用doGet方法...");

        Date date = new Date();

        // 1、添加响应头
        response.addHeader("name", "TD");
        response.addIntHeader("age", 28);
        response.addDateHeader("birthday", date.getTime());

        // 2、设置响应头
        response.setHeader("age", "26");

        // 3、设置定时刷新的头 （44行代码注释后执行）
        //response.setHeader("refresh", "5;url=http://www.baidu.com");

        // 4、封装的重定向方法（转到其他页面）
        //response.sendRedirect("/a_HTTPServletResponse_setStatus");
    }
}