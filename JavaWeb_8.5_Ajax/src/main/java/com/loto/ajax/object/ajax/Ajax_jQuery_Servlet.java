package com.loto.ajax.object.ajax;

/** 功能：Ajax_jQuery_Servlet
 * 访问地址：http://localhost:8080/JavaWeb01/06_Ajax/02_Ajax_jQuery.html
 * @author 蓝田
 * @date 2017年10月30日
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ajax_jQuery_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 中文编码（post异步访问服务器端时产生的问题）
		request.setCharacterEncoding("UTF-8");

		// 接收请求参数
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(name + "  " + age);

		// java代码只能返回一个json格式的字符串
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("{\"name\":\"蓝田\",\"age\":21}"); // 转义字符\"，转成一个单引号
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
