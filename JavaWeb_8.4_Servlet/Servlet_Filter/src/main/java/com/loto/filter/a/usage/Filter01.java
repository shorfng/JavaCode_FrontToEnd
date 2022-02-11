package com.loto.filter.a.usage;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Author：蓝田_Loto
 * Date：2017年11月1日
 * PageName：Filter01.java
 * Function：Filter的编写步骤
 */

public class Filter01 implements Filter {
    // Filter对象初始化方法，Filter对象创建时执行
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 获得过滤器的配置的名称（获得web.xml中filter 的名称 <filter-name>xxx</filter-name>）
        String filterName = filterConfig.getFilterName();
        System.out.println("过滤器名称：" + filterName);   // Filter01

        // 根据参数名获得当前filter的初始化参数
        String username = filterConfig.getInitParameter("username");
        String password = filterConfig.getInitParameter("password");
        System.out.println("初始化参数：" + username + "   " + password);

        // 获得所有的初始化参数的名称
        Enumeration<String> names = filterConfig.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = filterConfig.getInitParameter(name);
            System.out.println(name + "：" + value);
        }

        // 获得 servletContext
        ServletContext servletContext = filterConfig.getServletContext();
        System.out.println("servletContext："+servletContext);

        System.out.println("init 01...");
    }

    // Filter执行过滤的核心方法
    // request: 内部封装是客户端http请求的内容
    // response: 代表是响应
    // FilterChain: 过滤器链对象
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter 01...");

        // 放行请求
        chain.doFilter(request, response);
    }

    // Filter销毁方法，当Filter对象销毁时执行该方法
    @Override
    public void destroy() {
        System.out.println("destroy 01...");
    }
}
