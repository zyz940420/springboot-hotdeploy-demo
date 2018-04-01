package com.yuzhou.classload;

/**
 * 封装加载类的信息
 * 
 * @author zhangyuzhou
 *
 */
public class LoadInfo {
	private MyClassLoader myClassLoader;
	// 记录要加载的类的时间戳，加载的时间
	private long loadTime;

	private BaseManager baseManager;

	public LoadInfo(MyClassLoader myClassLoader, long loadTime) {
		super();
		this.myClassLoader = myClassLoader;
		this.loadTime = loadTime;
	}

	public BaseManager getBaseManager() {
		return baseManager;
	}

	public void setBaseManager(BaseManager baseManager) {
		this.baseManager = baseManager;
	}

	public long getLoadTime() {
		return loadTime;
	}

	public void setLoadTime(long loadTime) {
		this.loadTime = loadTime;
	}

	public MyClassLoader getMyClassLoader() {
		return myClassLoader;
	}

	public void setMyClassLoader(MyClassLoader myClassLoader) {
		this.myClassLoader = myClassLoader;
	}

}
