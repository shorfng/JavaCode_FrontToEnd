package com.loto.filter.b.autologin.web.servlet;

import com.loto.filter.b.autologin.domain.User;
import com.loto.filter.b.autologin.service.AutoLoginService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

/**
 * Author：蓝田_Loto
 * Date：2017年11月1日
 * PageName：AutoLoginServlet.java
 * Function：自动登录的servlet
 */

public class AutoLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("调用doPost方法...");

        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // 获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AutoLoginService service = new AutoLoginService();
        User user = null;
        try {
            user = service.login(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 如果登录成功
        if (user != null) {
            String autoLogin = request.getParameter("autoLogin");
            // 判断用户是否勾选自动登录
            if (autoLogin != null) {
                // 对中文进行编码
                String username_code = URLEncoder.encode(username, "UTF-8");

                // 创建 Cookie 存储用户名和密码
                Cookie cookie_username = new Cookie("cookie_username", username_code);
                Cookie cookie_password = new Cookie("cookie_password", password);

                // 设置cookie的持久化时间
                cookie_username.setMaxAge(60 * 60);
                cookie_password.setMaxAge(60 * 60);

                // 设置cookie的携带路径
                cookie_username.setPath(request.getContextPath());
                cookie_password.setPath(request.getContextPath());

                // 发送cookie
                response.addCookie(cookie_username);
                response.addCookie(cookie_password);
            }
            // 将登录用户的user对象存到session中，记录登录状态，重定向成功页面
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath()+"/b_autologin/success.jsp");
        } else {
            // 登录失败：转发到登录页面，提出提示信息
            request.setAttribute("loginInfo", "用户名或密码错误");
            request.getRequestDispatcher("/b_autologin/login.jsp").forward(request, response);
        }

        response.getWriter().write("调用doGet方法...");
    }
}