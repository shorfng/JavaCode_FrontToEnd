package com.loto.listener.b.Attribute;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Author：蓝田_Loto
 * Date：2019-01-05 16:07
 * PageName：b_HttpSessionAttributeListener.java
 * Function：HttpSessionAttributeListener（监听session对象属性attribute 添加、替换、删除）
 */

public class b_HttpSessionAttributeListener implements HttpSessionAttributeListener {
    // 添加到域中的属性
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("HttpSession 添加到域中的属性:");
        System.out.println(se.getName());
        System.out.println(se.getValue());
    }

    // 获得域中修改前的属性
    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("HttpSession 获得域中修改前的属性：");
        System.out.println(se.getName());
        System.out.println(se.getValue());
    }

    // 删除域中的属性
    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("HttpSession 删除域中的属性：");
        System.out.println(se.getName());
        System.out.println(se.getValue());
    }
}