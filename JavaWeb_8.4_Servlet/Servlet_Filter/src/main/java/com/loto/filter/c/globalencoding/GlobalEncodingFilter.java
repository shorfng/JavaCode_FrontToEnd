package com.loto.filter.c.globalencoding;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Author：蓝田_Loto
 * Date：2017年11月1日
 * PageName：GlobalEncodingFilter.java.java
 * Function：使用 Filter 全局解决get/post请求的中文乱码问题
 */

public class GlobalEncodingFilter implements Filter {
    private FilterConfig config;
    private String defaultCharset = "utf-8";

    // Filter对象初始化方法，Filter对象创建时执行
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        this.config = arg0;
    }

    // Filter执行过滤的核心方法
    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
        String charset = this.config.getInitParameter("charset");

        if (charset == null) {
            charset = defaultCharset;
        }

        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;

        // 解决 Post 请求的中文乱码问题
        request.setCharacterEncoding(charset);
        response.setCharacterEncoding(charset);
        response.setContentType("text/html;charset=" + charset);

        chain.doFilter(request, response);
    }

    // Filter销毁方法，当Filter对象销毁时执行该方法
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}

// 使用装饰者设计模式，编写自定义Request对象
class MyRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;  // 成员变量

    // 构造方法
    public MyRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    // 获得指定名称的第一个参数
    @Override
    public String getParameter(String name) {
        String value = this.request.getParameter(name);

        if (!request.getMethod().equalsIgnoreCase("get")) {
            return value;
        }

        if (value == null) {
            return null;
        }

        // 解决 Get 请求的中文乱码问题
        try {
            return value = new String(value.getBytes("iso8859-1"), request.getCharacterEncoding());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
