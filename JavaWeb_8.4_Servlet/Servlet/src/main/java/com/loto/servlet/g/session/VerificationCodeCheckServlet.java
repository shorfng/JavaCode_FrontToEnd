package com.loto.servlet.g.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author：蓝田_Loto
 * Date：2019-01-04 16:39
 * PageName：.java
 * Function：验证码的校验
 */

public class VerificationCodeCheckServlet extends HttpServlet {
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

        // 验证码校验功能
        // 1、获得页面输入的验证码
        String checkCode_client = request.getParameter("checkCode");

        // 2、获得生成图片的文字的验证码
        String checkCode_session = (String) request.getSession().getAttribute("checkcode_session");

        // 3、比对 页面的输入的验证码 和 生成图片的文字的验证码 是否一致
        if (!checkCode_session.equals(checkCode_client)) {
            request.setAttribute("loginInfo", "您的验证码不正确");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

        // 4、获得页面的用户名和密码进行数据库的校验
        // ......
    }
}