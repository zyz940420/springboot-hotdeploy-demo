package com.yuzhou.classload;

/**
 * 后台线程不断刷新，实现类热加载
 * 
 * @author zhangyuzhou
 *
 */
public class MsgHandler implements Runnable {
	@Override
	public void run() {
		while (true) {
			try {
				BaseManager baseManager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
				baseManager.logic();
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
