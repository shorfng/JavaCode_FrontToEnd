package com.loto.filter.b.autologin.web.filter;

import com.loto.filter.b.autologin.domain.User;
import com.loto.filter.b.autologin.service.AutoLoginService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

/**
 * Author：蓝田_Loto
 * Date：2017年11月1日
 * PageName：AutoLoginFilter.java
 * Function：自动登录的Filter
 */

public class AutoLoginFilter implements Filter {

    // Filter对象初始化方法，Filter对象创建时执行
	@Override
	public void init(FilterConfig fConfig) throws ServletException  {

	}

    // Filter执行过滤的核心方法
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		// 获得cookie中用户名和密码，进行登录的操作
		String cookie_username = null;
		String cookie_password = null;

		// 获得cookie
		Cookie[] cookies = req.getCookies();

		// 判断cookie是否为空，如果不为空，则取出数据
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				// 获得名字是cookie_username和cookie_password
				if ("cookie_username".equals(cookie.getName())) {
					cookie_username = cookie.getValue();
					cookie_username = URLDecoder.decode(cookie_username, "UTF-8");  // 恢复中文用户名
				}
				if ("cookie_password".equals(cookie.getName())) {
					cookie_password = cookie.getValue();
				}
			}
		}

		// 判断username和password是否是null
		if (cookie_username != null && cookie_password != null) {
			// 登录的代码
			AutoLoginService service = new AutoLoginService();
			User user = null;
			try {
				user = service.login(cookie_username, cookie_password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// 将登录的用户的user对象存到session中
			session.setAttribute("user", user);
		}
		// 放行
		chain.doFilter(req, resp);
	}

    // Filter销毁方法，当Filter对象销毁时执行该方法
	@Override
	public void destroy() {

	}
}
