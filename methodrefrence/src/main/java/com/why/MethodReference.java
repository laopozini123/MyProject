package com.why;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：why
 * @date ：Created in 2020/5/10 9:54
 * @description：
 * @version:
 */
public class MethodReference {
    public static void main(String[] args){
        List<String> names = new ArrayList();
        names.add("大明");
        names.add("二明");
        names.add("小明");
        names.forEach(System.out::println);
        names.stream().forEach(System.out::println);
    }
}
