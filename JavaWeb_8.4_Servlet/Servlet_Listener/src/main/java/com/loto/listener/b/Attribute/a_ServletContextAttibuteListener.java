package com.loto.listener.b.Attribute;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Author：蓝田_Loto
 * Date：2019-01-05 16:07
 * PageName：a_ServletContextAttibuteListener.java
 * Function：ServletContextAttributeListener（监听servletcontext对象属性attribute 添加、替换、删除）
 */

public class a_ServletContextAttibuteListener implements ServletContextAttributeListener {
    // 添加到域中的属性
    @Override
    public void attributeAdded(ServletContextAttributeEvent scab) {
        System.out.println("ServletContext 添加到域中的属性:");
        System.out.println(scab.getName());  // 放到域中的name
        System.out.println(scab.getValue()); // 放到域中的value
    }

    // 获得域中修改前的属性
    @Override
    public void attributeReplaced(ServletContextAttributeEvent scab) {
        System.out.println("ServletContext 获得域中修改前的属性：");
        System.out.println(scab.getName());  // 获得修改前的name
        System.out.println(scab.getValue()); // 获得修改前的value
    }

    // 删除域中的属性
    @Override
    public void attributeRemoved(ServletContextAttributeEvent scab) {
        System.out.println("ServletContext 删除域中的属性：");
        System.out.println(scab.getName());  // 删除的域中的name
        System.out.println(scab.getValue()); // 删除的域中的value
    }

}