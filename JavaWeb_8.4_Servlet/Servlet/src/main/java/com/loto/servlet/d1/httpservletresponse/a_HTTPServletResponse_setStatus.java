package com.loto.servlet.d1.httpservletresponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author：蓝田_Loto
 * Date：2019-01-03 15:30
 * PageName：a_HTTPServletResponse_setStatus.java
 * Function：通过 HTTPServletResponse 设置HTTP的响应行
 */

public class a_HTTPServletResponse_setStatus extends HttpServlet {
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

        // 手动设置HTTP响应行中的状态码
        response.setStatus(404);
    }
}