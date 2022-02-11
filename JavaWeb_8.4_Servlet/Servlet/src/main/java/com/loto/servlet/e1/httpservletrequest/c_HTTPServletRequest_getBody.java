package com.loto.servlet.e1.httpservletrequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * Author：蓝田_Loto
 * Date：2019-01-03 18:12
 * PageName：c_HTTPServletRequest_getBody.java
 * Function：通过 HTTPServletRequest 获取HTTP的请求体
 */

public class c_HTTPServletRequest_getBody extends HttpServlet {
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

        // 1、获得单个表单值
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);

        // 2、获得多个表单的值
        String[] hobbys = request.getParameterValues("hobby");
        for (String hobby : hobbys) {
            System.out.println("爱好：" + hobby);
        }

        // 3、获得所有的请求参数的名称
        System.out.println("====== 获得所有的请求参数的名称 =======");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            System.out.println(parameterNames.nextElement());
        }

        System.out.println("=============");

        // 4、以键值对形式，获得所有的请求参数：参数封装到一个Map<String,String[]>
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            System.out.println("键：" + entry.getKey());  // 打印键
            for (String str : entry.getValue()) {
                System.out.println("值：" + str);  // 打印值
            }
            System.out.println("");
        }
    }
}