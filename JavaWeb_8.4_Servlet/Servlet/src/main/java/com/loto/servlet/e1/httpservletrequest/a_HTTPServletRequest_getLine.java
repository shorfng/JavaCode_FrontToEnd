package com.loto.servlet.e1.httpservletrequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author：蓝田_Loto
 * Date：2019-01-03 18:10
 * PageName：a_HTTPServletRequest_getLine.java
 * Function：通过 HTTPServletRequest 获取HTTP的请求行
 */

public class a_HTTPServletRequest_getLine extends HttpServlet {
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

        // 1、获得客户端的请求方式：[String] getMethod()
        String method = request.getMethod();
        System.out.println("method:" + method); // method:GET

        // 2、获得请求的资源
        // （1）[String] getRequestURI() 和 [StringBuffer] getRequestURL()
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("uri:" + requestURI); // uri:/JavaWeb_4_3_04_Servlet_war_exploded/a_HTTPServletRequest_getLine
        System.out.println("url:" + requestURL); // url:http://localhost:8080/JavaWeb_4_3_04_Servlet_war_exploded/a_HTTPServletRequest_getLine

        // （2）动态获取web应用的名称 -> [String] getContextPath()
        String contextPath = request.getContextPath();
        System.out.println("web应用的名称：" + contextPath); // web应用的名称：/JavaWeb_4_3_04_Servlet_war_exploded

        // （3）获取的是get提交url地址后的参数字符串 -> [String] getQueryString()
        String queryString = request.getQueryString();
        System.out.println(queryString); // username=xxx&password=xxx

        // 3、获得客户机的信息 -> 获得访问者IP地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println("IP:" + remoteAddr); // IP:0:0:0:0:0:0:0:1

        System.out.println("================================================");
        PrintWriter out = response.getWriter();
        // 获取请求行的相关信息
        out.println("getMethod : " + request.getMethod() + "<br>");
        out.println("getRequestURI : " + request.getRequestURI() + "<br>");
        out.println("getQueryString:" + request.getQueryString() + "<br>");
        out.println("getProtocol : " + request.getProtocol() + "<br>");
        out.println("getContextPath:" + request.getContextPath() + "<br>");
        out.println("getPathInfo : " + request.getPathInfo() + "<br>");
        out.println("getPathTranslated : " + request.getPathTranslated() + "<br>");
        out.println("getServletPath:" + request.getServletPath() + "<br>");
        out.println("getRemoteAddr : " + request.getRemoteAddr() + "<br>");
        out.println("getRemoteHost : " + request.getRemoteHost() + "<br>");
        out.println("getRemotePort : " + request.getRemotePort() + "<br>");
        out.println("getLocalAddr : " + request.getLocalAddr() + "<br>");
        out.println("getLocalName : " + request.getLocalName() + "<br>");
        out.println("getLocalPort : " + request.getLocalPort() + "<br>");
        out.println("getServerName : " + request.getServerName() + "<br>");
        out.println("getServerPort : " + request.getServerPort() + "<br>");
        out.println("getScheme : " + request.getScheme() + "<br>");
        out.println("getRequestURL : " + request.getRequestURL() + "<br>");
    }
}