package com.loto.filter.a.usage;

import javax.servlet.*;
import java.io.IOException;

public class Filter02 implements Filter {
    // Filter对象初始化方法，Filter对象创建时执行
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("init 02...");
    }

    // Filter执行过滤的核心方法
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter 02...");

        // 放行请求
        chain.doFilter(request, response);
    }

    // Filter销毁方法，当Filter对象销毁时执行该方法
    @Override
    public void destroy() {
        System.out.println("destroy 02...");
    }
}
