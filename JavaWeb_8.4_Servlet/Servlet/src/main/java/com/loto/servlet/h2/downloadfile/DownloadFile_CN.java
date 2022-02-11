package com.loto.servlet.h2.downloadfile;

import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Author：蓝田_Loto
 * Date：2017年10月19日
 * PageName：DownloadFile_CN.java
 * Function：文件下载（文件是中文名称）
 */
public class DownloadFile_CN extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置request对象的解码方式
        request.setCharacterEncoding("utf-8");

        // 1、获取要下载文件的名称
        String downloadFileName = request.getParameter("filename");

        // 2、解决 获取要下载文件的名称 是中文参数的乱码问题
        //downloadFileName = new String(downloadFileName.getBytes("ISO8859-1"), StandardCharsets.UTF_8);
        // 获取请求头中的User-Agent
        String agent = request.getHeader("User-Agent");

        // 根据不同浏览器进行不同的编码
        String filenameEncoder;
        if (agent.contains("MSIE")) {
            // IE浏览器：UTF-8编码方式
            filenameEncoder = URLEncoder.encode(downloadFileName, "utf-8");
            filenameEncoder = filenameEncoder.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器：Base64编码方式
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filenameEncoder = "=?utf-8?B?" + base64Encoder.encode(downloadFileName.getBytes(StandardCharsets.UTF_8)) + "?=";
        } else {
            // 其它浏览器
            filenameEncoder = URLEncoder.encode(downloadFileName, "utf-8");
        }

        // 3、文件下载设置
        //（1）设置Content-Type头，告知浏览器，要下载文件的类型 -> 客户端通过文件的MIME类型去区分类型
        response.setContentType(this.getServletContext().getMimeType(downloadFileName));

        //（2）设置Content-Disposition头，告知浏览器，要下载文件的打开方式是下载，而不是直接解析（客户端默认对名字进行解码）
        response.setHeader("Content-Disposition", "attachment;filename=" + filenameEncoder);

        // 4、文件下载的准备
        //（1）获取要下载文件的绝对路径 -> download文件夹下
        String path = this.getServletContext().getRealPath("download/" + downloadFileName);

        //（2）获取要下载文件的输入流 -> 用io读取到该文件
        InputStream in = new FileInputStream(path);

        //（3）获取要下载的文件的输出流 -> 将该文件写到response的缓冲区中，用于向客户端写内容
        ServletOutputStream out = response.getOutputStream();

        // 5、文件拷贝（固定代码）
        int len;
        byte[] buffer = new byte[1024];
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }

        // 6、关闭资源
        in.close();
    }
}