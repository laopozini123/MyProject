package com.why;

/**
 * @author ：why
 * @date ：Created in 2020/5/10 14:51
 * @description：
 * @version:
 */
public class Demo {
    public static void main(String[] args) {
        String str = "10123345";
        String regex = "[1-9]\\d{4,11}";
        boolean qq = isQQ(str, regex);
        System.out.println("是不是QQ号呢:" + qq);
    }

    public static boolean isQQ(String str, String regex) {
        return str.matches(regex);
    }
}
