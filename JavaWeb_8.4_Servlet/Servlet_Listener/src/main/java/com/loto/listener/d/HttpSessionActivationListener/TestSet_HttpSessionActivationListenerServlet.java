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
 * PageName：TestSet_HttpSessionActivationListenerServlet.java
 * Function：存数据
 */

public class TestSet_HttpSessionActivationListenerServlet extends HttpServlet {
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

        HttpSession session = request.getSession();

        // 将对象放到session中
        JavaBean p = new JavaBean();
        p.setId("200");
        p.setName("CJ");
        session.setAttribute("p", p);
        System.out.println("p对象被放到session域中了");
    }
}