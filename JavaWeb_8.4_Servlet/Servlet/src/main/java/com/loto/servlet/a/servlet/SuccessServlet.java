package com.loto.servlet.a.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * Author：蓝田_Loto
 * Date：2018-12-30 16:39
 * PageName：SuccessServlet.java
 * Function：提交成功
 */

public class SuccessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("调用doPost方法...");

        String s = request.getMethod();
        System.out.println("http的请求方式是：" + s);

        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置response的编码，并指定浏览器解析页面时的编码
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().write("调用doGet方法...");

        // 使用参数名获得一个值
        String username = request.getParameter("username");  // 获得用户名
        String password = request.getParameter("password");  // 获得密码
        System.out.println(username + " : " + password);

        // 使用参数名获得一组值
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));

        // 获得所有数据，遍历Map
        System.out.println("---------------");
        Map<String, String[]> allData = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : allData.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(" --> ");
            System.out.println(Arrays.toString(entry.getValue()));
        }

        // 点击index.html以post方式提交，通过web.xml调用此servlet，重定向到success.html
        response.sendRedirect(request.getContextPath() + "/a_Servlet/success.html");
    }
}
