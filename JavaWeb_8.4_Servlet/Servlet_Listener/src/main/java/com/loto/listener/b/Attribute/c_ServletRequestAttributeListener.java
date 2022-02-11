package com.loto.listener.b.Attribute;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Author：蓝田_Loto
 * Date：2019-01-05 16:08
 * PageName：c_ServletRequestAttributeListener.java
 * Function：ServletRequestAttributeListener（监听request对象属性attribute 添加、替换、删除）
 */

public class c_ServletRequestAttributeListener implements ServletRequestAttributeListener {
    // 添加到域中的属性
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("HttpServletRequest 添加到域中的属性:");
        System.out.println(srae.getName());
        System.out.println(srae.getValue());
    }

    // 获得域中修改前的属性
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("HttpServletRequest 获得域中修改前的属性：");
        System.out.println(srae.getName());
        System.out.println(srae.getValue());
    }

    // 删除域中的属性
    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("HttpServletRequest 删除域中的属性：");
        System.out.println(srae.getName());
        System.out.println(srae.getValue());
    }
}
