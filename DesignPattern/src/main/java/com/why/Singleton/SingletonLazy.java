package com.why.Singleton;

/**
 * @author ：why
 * @date ：Created in 2020/5/9 10:01
 * @description： 懒汉式
 * @version:
 */
public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {
    }

    public synchronized static SingletonLazy getInstance() {
        if (instance == null) {
            instance =  new SingletonLazy();
        }
        return instance;
    }
}
