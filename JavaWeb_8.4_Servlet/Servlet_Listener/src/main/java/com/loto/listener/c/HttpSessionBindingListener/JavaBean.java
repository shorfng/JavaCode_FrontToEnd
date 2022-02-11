package com.loto.listener.c.HttpSessionBindingListener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Author：蓝田_Loto
 * Date：2019-01-05 19:08
 * PageName：JavaBean.java
 * Function：监听特殊JavaBean在session作用域绑定或解绑的监听器
 */

public class JavaBean implements HttpSessionBindingListener {
    private String id;
    private String name;

    // 绑定方法（给作用域添加数据）
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("HttpSessionBindingListener 监听器被绑定到Session域中了");
    }

    // 解绑方法（从作用域移除数据）
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("HttpSessionBindingListener 监听器从Session域中解绑了");
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
