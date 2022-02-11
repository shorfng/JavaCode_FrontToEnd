package com.loto.servlet.b.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author：蓝田_Loto
 * Date：2019-01-03 14:28
 * PageName：b_ServletContext_set.java
 * Function：存数据 - 可以在多个servlet之间共享数据（域对象的通用方法）
 */

public class b_ServletContext_set extends HttpServlet {
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

        // 获得ServletContext对象
        ServletContext context = getServletContext();

        // 域对象（在 b_ServletContext_set 中存数据，在 c_ServletContext_get 中取数据）
        context.setAttribute("name", "TD");
        System.out.println("存储完毕！");
    }
}