package com.loto.servlet.e1.httpservletrequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author：蓝田_Loto
 * Date：2019-01-03 18:16
 * PageName：d_HTTPServletRequest_set.java
 * Function：向 request 域中存储数据 -> 要转发的内容
 */

public class d_HTTPServletRequest_set extends HttpServlet {
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

        // 1、向 request 域中存储数据 -> 要转发的内容
        request.setAttribute("name", "TD");

        // 2、获得请求转发器
        RequestDispatcher dispatcher = request.getRequestDispatcher("/e_HTTPServletRequest_get");

        // 3、通过转发器将对象转发：forward(ServletRequest request, ServletResponse response)
        dispatcher.forward(request, response);
    }
}