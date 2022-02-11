package com.loto.servlet.h2.downloadfile;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Author：蓝田_Loto
 * Date：2017年10月19日
 * PageName：DownloadFile_EN.java
 * Function：文件下载（文件是英文名称）
 */

public class DownloadFile_EN extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1、获取要下载文件的名称
		String downloadFileName = request.getParameter("filename");
		
		// 2、告知浏览器，要下载文件的类型 -> 客户端通过文件的MIME类型去区分类型
		response.setContentType(this.getServletContext().getMimeType(downloadFileName));
		
		// 3、告知浏览器，要下载文件的打开方式是下载，而不是直接解析
		response.setHeader("Content-Disposition", "attachment;filename=" + downloadFileName);

		// 4、获取要下载文件的绝对路径 -> download文件夹下
		String path = this.getServletContext().getRealPath("download/" + downloadFileName);

		// 5、获取要下载文件的输入流 -> 用io读取到该文件
		InputStream in = new FileInputStream(path);

		// 6、获取要下载的文件的输出流 -> 将该文件写到response的缓冲区中，用于向客户端写内容
		ServletOutputStream out = response.getOutputStream();

		// 7、文件拷贝（固定代码）
		int len;
		byte[] buffer = new byte[1024];
		while ((len = in.read(buffer)) > 0) {
			out.write(buffer, 0, len);
		}

		// 8、关闭资源
		in.close();
		// out.close(); // 输出流可以不关闭，response会自动检查关闭
	}
}