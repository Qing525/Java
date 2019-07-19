package singleton;

/**
 * 静态常量          &&   静态代码块
 *
 * 饿汉式   （类加载完成初始化）
 *  可能会造成资源浪费
 *
 *
 */
public class Singleton {


    //private static  Singleton singleton=new Singleton();

    private static Singleton singleton;

    static {

        singleton = new Singleton();
    }

    private Singleton() {
    }

    private static Singleton getSingleton() {

        return singleton;
    }
}