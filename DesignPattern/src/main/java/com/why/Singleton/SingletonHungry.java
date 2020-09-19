package com.why.Singleton;

/**
 * @author ：why
 * @date ：Created in 2020/5/9 10:06
 * @description：饿汉式
 * @version:
 */
public class SingletonHungry {
    private static SingletonHungry instance = new SingletonHungry();

    private SingletonHungry() {
    }

    public static synchronized SingletonHungry getInstance() {
        if (instance == null) {
            instance = new SingletonHungry();
        }
        return instance;
    }
}

