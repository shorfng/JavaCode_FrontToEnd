package com.loto.filter.b.autologin.dao;

import com.loto.filter.b.autologin.domain.User;
import com.loto.filter.b.autologin.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AutoLoginDao {
    // 用户登录
    public User login(String username, String password) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username=? and password=?";

        return runner.query(sql, new BeanHandler<User>(User.class), username, password);
    }
}
