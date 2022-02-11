package com.loto.servlet.e2.example;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Author：蓝田_Loto
 * Date：2019-01-03 19:53
 * PageName：UserLoginServlet.java
 * Function：用户登录失败的信息回显
 */

public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置response的编码，并指定浏览器解析页面时的编码
        response.setContentType("text/html;charset=UTF-8");

        // 设置request的编码 -> post方式中文乱码解决
        request.setCharacterEncoding("UTF-8");

        response.getWriter().write("调用doPost方法...");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、获得用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2、调用一个业务方法进行该用户查询
        User login = null;
        try {
            login = login(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 3、通过user是否为null判断用户名和密码是否正确
        if (login != null) {
            // 用户名和密码正确：登录成功，跳转到网站的首页index.html
            response.sendRedirect(request.getContextPath());
        } else {
            // 用户名或密码错误：跳回当前login.jsp
            // 使用转发，转发到login.jsp，向request域中存储错误信息
            request.setAttribute("loginInfo", "用户名或密码错误");
            request.getRequestDispatcher("/g_example/login.jsp").forward(request, response);
        }
    }

    // 登录方法
    private User login(String username, String password) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username=? and password=?";

        return runner.query(sql, new BeanHandler<>(User.class), username, password);
    }
}
