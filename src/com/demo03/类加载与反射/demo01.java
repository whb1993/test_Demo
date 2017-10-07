package com.demo03.类加载与反射;

import org.apache.poi.util.StringUtil;
import org.junit.Test;
import sun.misc.Launcher;

import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created by wanghongbin on 2017/9/25 10:08.
 * 初识类加载
 */
public class demo01 {
    public static void main(String[] args) {

        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urLs.length; i++) {
            System.out.println(urLs[i].toExternalForm());
        }

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器"+systemClassLoader);
        try {
            Enumeration<URL> eml = systemClassLoader.getResources("");
            while (eml.hasMoreElements()){
                System.out.println(eml.nextElement());
            }
            ClassLoader extensionLader = systemClassLoader.getParent();
            System.out.println("扩展类加载属性"+extensionLader);
            System.out.println("扩展类加载器的加载路径"+System.getProperty("java.ext.dirs"));
            System.out.println("扩展类加载器的Parent："+extensionLader.getParent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHashMap(){
        HashMap<String, String> st = new HashMap<>();
        st.put(null,null);
        st.put("",null);
        System.out.println(st.get(null)!=null);
    }
}
