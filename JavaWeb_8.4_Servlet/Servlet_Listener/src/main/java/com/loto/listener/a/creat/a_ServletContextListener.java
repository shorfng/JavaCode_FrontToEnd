package com.loto.listener.a.creat;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author：蓝田_Loto
 * Date：2019-01-05 15:59
 * PageName：a_ServletContextListener.java
 * Function：ServletContextListener（监听ServletContext对象创建或销毁）
 */

public class a_ServletContextListener implements ServletContextListener {
    // 监听 ServletContext 域对象的创建
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 获得被监听的对象
        ServletContext servletContext = sce.getServletContext();
        ServletContext source = (ServletContext) sce.getSource();
        System.out.println("ServletContext 创建了...");

        // 监听器的作用：任务调度举例
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentTime = "2017-08-19 00:00:00";
        Date parse = null;
        try {
            parse = format.parse(currentTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // web应用一启动，就开启任务调度
        Timer timer = new Timer();

        // 模仿银行计利息：每天晚上12点，计息一次，间隔时间为24小时
        // timer.scheduleAtFixedRate(task, firstTime, period);
        // task:任务 firstTime：第一次执行时间 period：间隔执行时间
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("银行计息了.....");
            }
        }, parse, 24 * 60 * 60 * 1000);
    }

    // 监听 ServletContext 域对象的销毁
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext 销毁了...");
    }
}
