package com.loto.listener.d.HttpSessionActivationListener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Author：蓝田_Loto
 * Date：2017年10月31日
 * PageName：TestGet_HttpSessionActivationListenerServlet.java
 * Function：获取数据
 */

public class TestGet_HttpSessionActivationListenerServlet extends HttpServlet {
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

        // 从session域中获得customer
        HttpSession session = request.getSession();
        JavaBean p = (JavaBean) session.getAttribute("p");

        System.out.println("从session域中取出p对象的属性："+p.getName());
    }
}