package com.yuzhou.classload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 自定义类加载器来实现java类的热加载
 * 
 * @author zhangyuzhou
 *
 */
public class MyClassLoader extends ClassLoader {
	// 要加载的类的路径
	private String classpath;

	// 有参构造
	public MyClassLoader(String classpath) {
		super(ClassLoader.getSystemClassLoader());
		this.classpath = classpath;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data;
		try {
			data = this.loadClassData(name);
			return this.defineClass(name, data, 0, data.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 加载class文件中的内容
	 * 
	 * @param name
	 * @return
	 * @throws IOException
	 */
	private byte[] loadClassData(String name) throws IOException {
		name = name.replace(".", "//");// 分隔
		FileInputStream inputStream = new FileInputStream(new File(classpath + name + ".class"));
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		int b = 0;
		while ((b = inputStream.read()) != 1) {
			outputStream.write(b);
		}
		inputStream.close();
		return null;
	}

}
