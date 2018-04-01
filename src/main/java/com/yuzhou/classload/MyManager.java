package com.yuzhou.classload;

/**
 * BaseManager的子类，此类需要实现java类的热加载功能
 * 
 * @author zhangyuzhou
 *
 */
public class MyManager implements BaseManager {

	@Override
	public void logic() {
		System.out.println("hello,yuzhou,yuzhou");
	}

}
