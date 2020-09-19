package com.why.Singleton;

/**
 * @author ：why
 * @date ：Created in 2020/5/9 10:01
 * @description：
 * @version:
 */
public class Demo {
    public static void main(String[] args){
        System.out.println(SingletonLazy.getInstance());
        System.out.println(SingletonLazy.getInstance());
        System.out.println(SingletonLazy.getInstance());
        System.out.println(SingletonLazy.getInstance());
        System.out.println(SingletonLazy.getInstance());
        System.out.println(SingletonLazy.getInstance());

        System.out.println("------------------------------------------------------");
        System.out.println(SingletonHungry.getInstance());
        System.out.println(SingletonHungry.getInstance());
        System.out.println(SingletonHungry.getInstance());
        System.out.println(SingletonHungry.getInstance());
        System.out.println(SingletonHungry.getInstance());
        System.out.println(SingletonHungry.getInstance());
    }
}
