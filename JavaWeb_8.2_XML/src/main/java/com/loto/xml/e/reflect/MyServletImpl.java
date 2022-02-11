package com.loto.xml.e.reflect;

public class MyServletImpl implements IMyServlet {

	@Override
	public void init() {
		System.out.println("初始化...");
	}

	@Override
	public void service() {
		System.out.println("服务开启...");
	}

	@Override
	public void destory() {
		System.out.println("结束...");
	}

}
