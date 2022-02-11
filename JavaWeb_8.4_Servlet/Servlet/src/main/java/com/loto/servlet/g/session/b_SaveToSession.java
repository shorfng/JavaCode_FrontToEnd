package com.loto.servlet.g.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Author：蓝田_Loto
 * Date：2019-01-04 16:29
 * PageName：b_SaveToSession.java
 * Function：向session中存数据
 */

public class b_SaveToSession extends HttpServlet {
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

        response.getWriter().write("向session中存数据...");

        // 1、创建属于该客户端/会话的私有session区域
        HttpSession session = request.getSession();

        // 2、向session中存储数据
        session.setAttribute("name", "TD");
    }
}