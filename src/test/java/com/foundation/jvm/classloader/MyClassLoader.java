package com.foundation.jvm.classloader;

import java.io.File;
import java.io.FileInputStream;

/**
 * @ClassName MyClassLoader
 * @Description
 * @Author xuxiangnan
 * @Date 2022/5/11 9:54
 */
public class MyClassLoader extends ClassLoader{
    private String classPath;

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            return defineClass(name,data,0,data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

    private byte[] loadByte(String name) throws Exception {
        String path = classPath + File.separator + name.replace('.', '/').concat(".class");
        final FileInputStream fileInputStream = new FileInputStream(path);
        byte[] data = new byte[fileInputStream.available()];
        fileInputStream.read(data);
        fileInputStream.close();
        return data;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        final MyClassLoader myClassLoader = new MyClassLoader("I:\\test");
        final Class<?> aClass = myClassLoader.loadClass("com.foundation.jvm.classloader.ClassLoaderBean");
        System.out.println(aClass.getClassLoader());
    }
}
