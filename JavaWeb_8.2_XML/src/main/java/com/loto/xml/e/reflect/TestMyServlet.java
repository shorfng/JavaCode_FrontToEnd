package com.loto.xml.e.reflect;

public class TestMyServlet {
    public static void main(String[] args) {

    }

	// 方式1：普通对象调用
	public void testMyServlet() {
		MyServletImpl my = new MyServletImpl();
		my.init();
		my.service();
		my.destory();
		System.out.println("===============");
	}

	// 方式2：反射执行
	public void testMyServlet1() {
		try {
			// 类全名
			String className = "com.loto.xml05.reflect";
			// 使用反射
			Class clazz = Class.forName(className);
			// 获取 字符串className 的实现类实例
			MyServletImpl my = (MyServletImpl) clazz.newInstance();
			// 执行对象的方法
			my.init();
			my.service();
			my.destory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
