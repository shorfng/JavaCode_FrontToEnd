package com.loto.listener.c.HttpSessionBindingListener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Author：蓝田_Loto
 * Date：2019-01-05 19:12
 * PageName：Test_HttpSessionBindingListenerServlet.java
 * Function：测试
 */

public class Test_HttpSessionBindingListenerServlet extends HttpServlet {
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

        JavaBean p = new JavaBean();
        p.setId("100");
        p.setName("TD");

        // 将对象绑定到session中
        session.setAttribute("person", p);

        // 将对象从session中解绑
        session.removeAttribute("person");
    }
}