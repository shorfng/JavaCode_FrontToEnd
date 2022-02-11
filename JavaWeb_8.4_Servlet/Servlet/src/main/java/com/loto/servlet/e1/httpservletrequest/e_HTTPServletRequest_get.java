package com.loto.servlet.e1.httpservletrequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author：蓝田_Loto
 * Date：2019-01-03 18:17
 * PageName：e_HTTPServletRequest_get.java
 * Function：从 request 域中取出数据 -> 接收到转发过来的数据
 */

public class e_HTTPServletRequest_get extends HttpServlet {
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

        // 4、从 request 域中取出数据 -> 接收到转发过来的数据
        Object attribute = request.getAttribute("name");

        // 5、显示转发内容
        response.getWriter().write("接收到的数据：" + attribute);
    }
}