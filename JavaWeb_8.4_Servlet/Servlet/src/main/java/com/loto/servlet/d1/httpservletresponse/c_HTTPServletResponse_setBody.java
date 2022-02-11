package com.loto.servlet.d1.httpservletresponse;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Author：蓝田_Loto
 * Date：2019-01-03 15:35
 * PageName：c_HTTPServletResponse_setBody.java
 * Function：通过 HTTPServletResponse 设置HTTP的响应体
 */

public class c_HTTPServletResponse_setBody extends HttpServlet {
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

        // response的getWriter()方法和getOutputStream()方法不能同时使用，会报错
        //response.getWriter().write("调用doGet方法...");

        // 1、设置文本
        PrintWriter writer = response.getWriter();
        writer.write("你好");

        // 2、设置字节
        // （1）使用response获得字节输出流
        ServletOutputStream out = response.getOutputStream();

        // （2）获得服务器上的图片
        String realPath = this.getServletContext().getRealPath("images/TD.jpg");

        // （3）输入流
        InputStream in = new FileInputStream(realPath);

        // （4）文件拷贝（固定代码）
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }

        // （5）关闭资源
        in.close();
        out.close();
    }
}
