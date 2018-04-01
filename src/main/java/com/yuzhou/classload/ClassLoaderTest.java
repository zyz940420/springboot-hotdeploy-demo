package com.yuzhou.classload;

/**
 * 测试类的热加载
 * 
 * @author zhangyuzhou
 *
 */
public class ClassLoaderTest {
	public static void main(String[] args) {
		new Thread(new MsgHandler()).start();
	}

}
