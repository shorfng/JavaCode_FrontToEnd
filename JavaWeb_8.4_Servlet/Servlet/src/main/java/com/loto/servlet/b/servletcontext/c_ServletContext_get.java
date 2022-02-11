package com.loto.servlet.b.servletcontext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author：蓝田_Loto
 * Date：2019-01-03 14:29
 * PageName：c_ServletContext_get.java
 * Function：取数据 - 可以在多个servlet之间共享数据（域对象的通用方法）
 */

public class c_ServletContext_get extends HttpServlet {
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

        // 域对象（从servletContext中取数据）
        String attribute = (String) this.getServletContext().getAttribute("name");
        System.out.println("读取到的数据：" + attribute);
    }
}