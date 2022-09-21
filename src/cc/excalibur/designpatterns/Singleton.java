package cc.excalibur.designpatterns;

/**
 * @author Excalibur
 * @date 2022/7/19 16:30
 */

/**
 * @return 单例模式
 */
public class Singleton {
    private static  Singleton unquietInstance;

    private volatile static Singleton volatileInstance;
//    直接加载 预加载 不节省资源
    private static Singleton uniqueInstance = new Singleton();
    public Singleton(){

    }
    /**
     * 枚举实现
     * 最佳实践 可以防止序列化和反射攻击
     */
//    public enum Singleton {
//        uniqueInstance;
//    }
    /**
     * 静态内部类
     */
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    /**
     * @return 静态内部类加载 利用java语言特性
     * 线程安全 懒加载
     */
    public static Singleton getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * @return 双重校验锁
     * 线程安全 开销小 实现复杂
     */
    public static Singleton getUnquietInstance(){
        if (volatileInstance==null){
            synchronized (Singleton.class){
                if (volatileInstance==null){
                    return new Singleton();
                }
            }
        }
        return volatileInstance;
    }

//    /**
//     * @return 加锁懒加载
//     * 线程安全 开销大
//     */
//    public static synchronized Singleton getUnquietInstance(){
//            if (unquietInstance==null){
//                return new Singleton();
//            }
//        return unquietInstance;
//    }



//    /**
//     * @return 单例对象
//     * 线程不安全的懒加载
//     */
//    public static Singleton  getUnquietInstance(){
//        if (unquietInstance==null){
//            unquietInstance=new Singleton();
//        }
//        return unquietInstance;
//    }
}
