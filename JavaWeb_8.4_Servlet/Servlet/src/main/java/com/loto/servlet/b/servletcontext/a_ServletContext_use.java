package com.loto.servlet.b.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author：蓝田_Loto
 * Date：2019-01-03 14:09
 * PageName：a_ServletContext_use.java
 * Function：
 */

public class a_ServletContext_use extends HttpServlet {
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

        // 作用1：设置web应用全局的初始化参数
        String initParameter = context.getInitParameter("driver");
        System.out.println(initParameter);

        // 作用2：获得web应用中任何资源的绝对路径（获得a b c d.txt的绝对路径）
        // （1）获得a.txt ---> 可以访问 WEBContent 目录下
        String realPath_A = context.getRealPath("a.txt");
        System.out.println(realPath_A);
        // （2）获得b.txt ---> 可以访问 WEB-INF 目录下
        String realPath_B = context.getRealPath("WEB-INF/b.txt");
        System.out.println(realPath_B);
        // （3）获得c.txt ---> 可以访问 java类文件 目录下
        String realPath_C = context.getRealPath("WEB-INF/classes/c.txt");
        System.out.println(realPath_C);
        // （4） 获得d.txt ---> 获取不到项目根目录文件s
    }
}