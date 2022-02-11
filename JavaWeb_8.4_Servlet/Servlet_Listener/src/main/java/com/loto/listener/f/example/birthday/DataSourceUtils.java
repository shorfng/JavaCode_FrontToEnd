package com.loto.listener.f.example.birthday;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSourceUtils {
	private static DataSource dataSource = new ComboPooledDataSource();
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

	// 直接可以获取一个连接池
	public static DataSource getDataSource() {
		return dataSource;
	}

	// 获取连接对象
	public static Connection getConnection() throws SQLException {
		Connection connection = threadLocal.get();
		if (connection == null) {
			connection = dataSource.getConnection();
			threadLocal.set(connection);
		}
		return connection;
	}

	// 开启事务
	public static void startTransaction() throws SQLException {
		Connection connection = getConnection();
		if (connection != null) {
			connection.setAutoCommit(false);
		}
	}

	// 事务回滚
	public static void rollback() throws SQLException {
		Connection connection = getConnection();
		if (connection != null) {
			connection.rollback();
		}
	}

	// 提交并且关闭资源，从ThreadLocall中释放
	public static void commitAndRelease() throws SQLException {
		Connection connection = getConnection();
		if (connection != null) {
			connection.commit();  // 事务提交
			connection.close();   // 关闭资源
			threadLocal.remove(); // 从线程绑定中移除
		}
	}

	// 关闭资源方法
	public static void closeConnection() throws SQLException {
		Connection connection = getConnection();
		if (connection != null) {
			connection.close();
		}
	}

	public static void closeStatement(Statement st) throws SQLException {
		if (st != null) {
			st.close();
		}
	}

	public static void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}
}
