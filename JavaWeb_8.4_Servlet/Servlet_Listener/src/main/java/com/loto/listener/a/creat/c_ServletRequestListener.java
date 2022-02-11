package com.loto.listener.a.creat;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Author：蓝田_Loto
 * Date：2019-01-05 16:02
 * PageName：c_ServletRequestListener.java
 * Function：ServletRequestListener（监听Request对象创建或销毁）
 */

public class c_ServletRequestListener implements ServletRequestListener {
    // 监听 ServletRequestListener 域对象的创建
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("ServletRequestListener 创建：" + sre.getServletContext());
        System.out.println("ServletRequestListener 创建：" + sre.getServletRequest());
    }

    // 监听 ServletRequestListener 域对象的销毁
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("ServletRequestListener 销毁");
    }

}
