package com.loto.listener.b.Attribute;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Author：蓝田_Loto
 * Date：2019-01-05 18:29
 * PageName：.java
 * Function：
 */

public class Test_AttributeListenerServlet extends HttpServlet {
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

        System.out.println("--------------------- ServletContextAttributeListener --------------------");
        ServletContext servletContext = this.getServletContext();

        // 添加数据到 ServletContext 域中
        servletContext.setAttribute("name", "TD");

        // 修改数据到 ServletContext 域中
        servletContext.setAttribute("name", "CJ");

        // 删除 ServletContext 域中的数据
        servletContext.removeAttribute("name");

        System.out.println("--------------------- HttpSessionAttributeListener --------------------");
        HttpSession httpSession = request.getSession();

        // 添加数据到 HttpSession 域中
        httpSession.setAttribute("name", "TD");

        // 修改数据到 HttpSession 域中
        httpSession.setAttribute("name", "CJ");

        // 删除 HttpSession 域中的数据
        httpSession.removeAttribute("name");

        System.out.println("--------------------- ServletRequestAttributeListener --------------------");
        // 添加数据到 HttpServletRequest 域中
        request.setAttribute("name", "TD");

        // 修改数据到 HttpServletRequest 域中
        request.setAttribute("name", "CJ");

        // 删除 HttpServletRequest 域中的数据
        request.removeAttribute("name");
    }
}