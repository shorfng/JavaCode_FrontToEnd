package com.loto.ajax.object.ajax;

/** 功能：Ajax_JS_Servlet   
 * 访问地址：http://localhost:8080/JavaWeb01/06_Ajax/01_Ajax_JS.html
 * @author 蓝田
 * @date 2017年10月27日
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ajax_JS_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 接收从浏览器传送的数据
		String parameter = request.getParameter("name");
		response.getWriter().write(Math.random() + "+"+parameter);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
