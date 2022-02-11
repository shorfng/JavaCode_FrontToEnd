package com.loto.listener.d.HttpSessionActivationListener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * Author：蓝田_Loto
 * Date：2019-01-05 19:18
 * PageName：JavaBean.java
 * Function：监听特殊JavaBean在session作用域钝化或活化的监听器
 */

public class JavaBean implements HttpSessionActivationListener, Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;

    // 钝化
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("HttpSessionActivationListener 监听器对象被钝化了");
    }

    // 活化
    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("HttpSessionActivationListener 监听器对象被活化了");
    }

    // setter、getter方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
