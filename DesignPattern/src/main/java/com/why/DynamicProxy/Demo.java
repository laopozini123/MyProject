package com.why.DynamicProxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author ：why
 * @date ：Created in 2020/5/9 11:25
 * @description：
 * @version:
 */
public class Demo {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("java");
        collection.add("exe");
        collection.add("cccc");
        collection.add("dddd");
        collection.add("eeee");
        collection.add("dddd");
        Collection collectionProxy = (Collection) Proxy.newProxyInstance(Collection.class.getClassLoader(), collection.getClass().getInterfaces(), (proxy, method, params) -> {
            System.out.println("动态代理");
            if (method.getName().equals("remove") && params.length == 1 && (params[0] instanceof Object)) {
                System.out.println(params[0]);
                boolean b = false;
                while (collection.contains(params[0])) {
                    b = (boolean) method.invoke(collection, params);
                }
                return b;
            }
            return method.invoke(collection, params);
        });
        collectionProxy.remove("dddd");
        System.out.println(collection);
    }
}
