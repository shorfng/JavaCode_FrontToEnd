package com.loto.servlet.e2.example;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

/**
 * Author：蓝田_Loto
 * Date：2019-01-03 19:53
 * PageName：RegisterServlet.java
 * Function：用户注册功能
 */

public class RegisterServlet extends HttpServlet {
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

        // 0、设置request的编码 -> post方式中文乱码解决
        request.setCharacterEncoding("UTF-8");
        // 设置request的编码 -> post方式中文乱码解决（先用iso8859-1编码，再使用utf-8解码）
        // String username = request.getParameter("username");
        // username = new String(username.getBytes("iso8859-1"),"UTF-8");

        // 2、使用BeanUtils进行自动映射封装
        // BeanUtils工作原理：将map中的数据，根据key与实体的属性的对应关系封装
        // 只要key的名字与实体的属性名字一样，就自动封装到实体中
        Map<String, String[]> properties = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, properties);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        // 至此，user对象已经封装好了

        // 手动封装uid：uuid是随机不重复的字符串，32位（java代码生成后是36位）
        user.setUid(UUID.randomUUID().toString());

        // 3、将参数传递给一个业务操作方法
        try {
            regist(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 4、认为注册成功跳转到登录页面
        response.sendRedirect(request.getContextPath() + "/g_example/login.jsp");
    }

    // 注册方法
    private void regist(User user) throws SQLException {
        // 3.1 sql语句
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";

        // 3.2 操作数据库
        runner.update(sql, user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), null,
                user.getBirthday(), user.getSex(), null, null);
    }
}