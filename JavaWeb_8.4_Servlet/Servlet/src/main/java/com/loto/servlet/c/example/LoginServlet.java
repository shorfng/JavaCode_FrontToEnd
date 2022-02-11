package com.loto.servlet.c.example;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Author：蓝田_Loto
 * Date：2019-01-03 14:39
 * PageName：UserLoginServlet.java
 * Function：用户登录验证
 */

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 在SeveltContext域中存一个数据count
    @Override
    public void init() {
        int count = 0;
        this.getServletContext().setAttribute("count", count);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("调用doPost方法...");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("调用doGet方法...");

        // 1、获得用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2、从数据库中验证该用户名和密码是否正确
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username=? and password=?";

        User user = null;
        try {
            user = runner.query(sql, new BeanHandler<>(User.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 3、根据返回的结果给用户不同显示信息
        if (user != null) {
            // 从 ServletContext 中取出count进行++运算
            ServletContext context = this.getServletContext();
            Integer count = (Integer) context.getAttribute("count");
            count++;

            // 用户登录成功,显示当前登录系统的人次
            response.getWriter().write(user.toString() + "----- success login:" + count);
            context.setAttribute("count", count);
        } else {
            // 用户登录失败
            response.getWriter().write("sorry your username or password is wrong!");
        }
    }
}