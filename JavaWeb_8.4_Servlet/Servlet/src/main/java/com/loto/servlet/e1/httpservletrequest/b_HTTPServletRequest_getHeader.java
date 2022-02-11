package com.loto.servlet.e1.httpservletrequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Author：蓝田_Loto
 * Date：2019-01-03 18:11
 * PageName：b_HTTPServletRequest_getHeader.java
 * Function：通过 HTTPServletRequest 获取HTTP的请求头
 */

public class b_HTTPServletRequest_getHeader extends HttpServlet {
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

        // 1、获得指定的头：[String] getHeader(String name)
        String header = request.getHeader("User-Agent");
        System.out.println(header);

        System.out.println("===============");

        // 2、获得所有的头的名称：[Enumeration] getHeaderNames()
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println(headerName + ":" + headerValue);
        }

        System.out.println("===============");

        // 3、请求头referer：执行该此访问的的来源，用于做防盗链
        String header_referer = request.getHeader("referer");
        if (header_referer != null && header_referer.startsWith("http://localhost")) {
            // 是从源网站跳转过来
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("True!是从源网站跳转过来....");
        } else {
            response.getWriter().write("False!你是盗链者!!!");
        }
    }
}