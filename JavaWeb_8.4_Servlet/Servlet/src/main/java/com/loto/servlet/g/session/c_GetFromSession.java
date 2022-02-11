package com.loto.servlet.g.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Author：蓝田_Loto
 * Date：2019-01-04 16:30
 * PageName：c_GetFromSession.java
 * Function：向session中取数据
 */

public class c_GetFromSession extends HttpServlet {
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

        // 1、创建属于该客户端/会话的私有session区域
        HttpSession session = request.getSession();

        // 2、从session中获得存储的数据
        Object attribute = session.getAttribute("name");
        response.getWriter().write(attribute + "");
    }
}