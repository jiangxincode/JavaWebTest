package chap21.singleton.demo1;

/**
 * 线程安全的写法，单例模式最优写法
 */
public class SingletonThreadSafe {
    private static volatile SingletonThreadSafe instance;

    private SingletonThreadSafe() {

    }

    public static SingletonThreadSafe getInstance() {
        if (instance == null) {
            synchronized (SingletonThreadSafe.class) {
                if (instance == null) {
                    instance = new SingletonThreadSafe();
                }
            }
        }

        return instance;
    }

}
