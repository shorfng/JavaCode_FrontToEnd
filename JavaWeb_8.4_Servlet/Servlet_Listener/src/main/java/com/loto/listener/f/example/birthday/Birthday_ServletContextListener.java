package com.loto.listener.f.example.birthday;

import com.loto.listener.e.example.email.MailUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.mail.MessagingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author：蓝田_Loto
 * Date：2017年10月31日
 * PageName：Birthday_ServletContextListener.java
 * Function：在用户的生日当前发送邮件
 */

public class Birthday_ServletContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 当web应用启动,开启任务调动,开启一个定时器
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			// 为当前的生日的用户发邮件
			public void run() {
				// 获得今天的日期
				SimpleDateFormat format = new SimpleDateFormat("MM-dd");
				String currentDate = format.format(new Date());

				// 根据当前时间从数据查询今天过生日的人
				QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
				String sql = "select * from user where birthday like ?";
				List<Customer> customerList = null;
				try {
					customerList = runner.query(sql, new BeanListHandler<Customer>(Customer.class),
							"%" + currentDate + "%");
				} catch (SQLException e) {
					e.printStackTrace();
				} // 08-18

				// 发邮件
				if (customerList != null && customerList.size() > 0) {
					for (Customer c : customerList) {
						String emailMsg = "亲爱的：" + c.getRealname() + ",生日快乐！";
						try {
							MailUtils.sendMail(c.getEmail(), "生日祝福", emailMsg);
							System.out.println(c.getRealname() + "邮件发送完毕");
						} catch (MessagingException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}, new Date(), 1000 * 10); // 实际开发中,起始时间是一个固定的时间,中间隔时间是1天
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
