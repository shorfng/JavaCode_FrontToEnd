package com.loto.filter.a.usage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author：蓝田_Loto
 * Date：2017年11月1日
 * PageName：FilterServlet01.java
 * Function：
 */

public class FilterServlet01 extends HttpServlet {
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

        System.out.println("FilterServlet01 ...");

        // 1、转发：转发的时候不执行filter
        // Filter1 -> Filter2 -> Servlet01 -> Servlet02
        request.getRequestDispatcher("/FilterServlet02").forward(request, response);

        // 2、重定向：重定向的时候执行filter，因为重定向也是直接访问资源
        // Filter1 -> Filter2 -> Servlet01 -> Filter1 -> Filter2 -> Servlet02
        // response.sendRedirect(request.getContextPath() + "/FilterServlet02");

        response.getWriter().write("调用doGet方法（FilterServlet01）...");
    }
}