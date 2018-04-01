package com.yuzhou.classload;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 加载manager的工厂
 * 
 * @author zhangyuzhou
 *
 */
public class ManagerFactory {
	private static final Map<String, LoadInfo> loadTimeMap = new HashMap<>();
	// 路径
	private static final String CLASS_PATH = "D:/mywork/stswork/springboot-hotdeploy-demo/target/";
	// 类全路径
	public static final String MY_MANAGER = "com.yuzhou.classload.MyManager";

	public static BaseManager getManager(String className) throws Exception {
		File load = new File(CLASS_PATH + className.replace("\\.", "/") + ".class");
		long lastModified = load.lastModified();
		// 如果还没有加载这个类，则加载这个类到jvm中
		if (loadTimeMap.get(className) == null) {
			load(className, lastModified);
		} else if (loadTimeMap.get(className).getLoadTime() != lastModified) {
			// 如果这个类的变过了，那么重新加载这个类
			load(className, lastModified);
		}
		return loadTimeMap.get(className).getBaseManager();
	}

	private static void load(String className, long lastModified) throws Exception {
		MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
		Class<?> loadClass = myClassLoader.loadClass(className);
		BaseManager baseManager = newInstance(loadClass);
		LoadInfo loadInfo = new LoadInfo(myClassLoader, lastModified);
		loadInfo.setBaseManager(baseManager);
		loadTimeMap.put(className, loadInfo);
	}

	private static BaseManager newInstance(Class<?> loadClass) throws Exception {
		// 以反射的方式创建BaseManager子类对象
		return (BaseManager) loadClass.getConstructor(new Class[] {}).newInstance(new Object[] {});
	}

}
