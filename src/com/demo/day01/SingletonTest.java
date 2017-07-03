package com.demo.day01;

/**
 * Created by Administrator on 2017/6/6.
 * 方法一
 * 单例模式的实现：饿汉式,线程安全 但效率比较低
 */
public class SingletonTest {

    // 定义一个私有的构造方法
    // 定义私有构造方法（防止通过 new SingletonTest()去实例化）
    private SingletonTest() {
    }

    // 将自身的实例对象设置为一个属性,并加上Static和final修饰符
    private static final SingletonTest instance = new SingletonTest();

    // 静态方法返回该类的实例
    public static SingletonTest getInstancei() {
        return instance;
    }

}
/**
 * 方法一就是传说的中的饿汉模式
 * 优点是：写起来比较简单，而且不存在多线程同步问题，避免了synchronized所造成的性能问题；
 * 缺点是：当类SingletonTest被加载的时候，会初始化static的instance，静态变量被创建并分配内存空间，从这以后，
 * 这个static的instance对象便一直占着这段内存（即便你还没有用到这个实例），当类被卸载时，静态变量被摧毁，
 * 并释放所占有的内存，因此在某些特定条件下会耗费内存。
 */
