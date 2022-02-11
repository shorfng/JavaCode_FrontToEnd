package com.loto.filter.b.autologin.service;

import com.loto.filter.b.autologin.domain.User;
import com.loto.filter.b.autologin.dao.AutoLoginDao;

import java.sql.SQLException;

public class AutoLoginService {
    // 用户登录
	public User login(String username, String password) throws SQLException {
		AutoLoginDao dao = new AutoLoginDao();
		return dao.login(username, password);
	}
}
