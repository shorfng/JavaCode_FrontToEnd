package com.loto.servlet.a.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author：蓝田_Loto
 * Date：2019-01-02 21:59
 * PageName：a_Servlet_use.java
 * Function：servlet的方法
 */

public class a_Servlet_use extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // servlet对象创建的时候执行
    @Override
    public void init(ServletConfig config) {
        System.out.println("调用init初始化方法...");

        // 1、获得servlet的name
        String servletName = config.getServletName();
        System.out.println(servletName); // servlet1

        // 2、获得该servlet的初始化的参数
        String initParameter = config.getInitParameter("url");
        System.out.println(initParameter);

        // 3、获得Servletcontext对象
        ServletContext servletContext = config.getServletContext();
        System.out.println(servletContext);
    }

    // 每次请求都会执行
    @Override
    public void service(ServletRequest req, ServletResponse res) throws IOException {
        res.getWriter().write("serviceMethod...");
    }

    // http的请求方式是post
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("调用doPost方法...");

        doGet(request, response);
    }

    // http的请求方式是get
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置response的编码，并指定浏览器解析页面时的编码
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().write("调用doGet方法...");
    }

    // servlet销毁的时候执行
    @Override
    public void destroy() {
        System.out.println("调用destroy销毁方法...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}