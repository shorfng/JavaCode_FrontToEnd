package com.loto.listener.a.creat;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Author：蓝田_Loto
 * Date：2019-01-05 16:01
 * PageName：b_HttpSessionListener.java
 * Function：HttpSessionListener（监听Session对象创建或销毁）
 */

public class b_HttpSessionListener implements HttpSessionListener {
    // 监听 HttpSessionListener 域对象的创建
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("HttpSessionListener 创建：" + se.getSession().getId());
    }

    // 监听 HttpSessionListener 域对象的销毁
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("HttpSessionListener 销毁");
    }
}