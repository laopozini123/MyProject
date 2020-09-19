package com.why;

import static java.lang.Math.*;

/**
 * @author ：why
 * @date ：Created in 2020/5/31 10:52
 * @description：
 * @version:
 */
public class JustForStudy {
    public static strictfp void main(String[] args) {
        float aFloat = 0.6710339f;
        double aDouble = 0.04150553411984792d;
        double sum = aFloat + aDouble;
        float quotient = (float) (aFloat / aDouble);
        System.out.println("float: " + aFloat);
        System.out.println("double: " + aDouble);
        System.out.println("sum: " + sum);
        System.out.println("quotient: " + quotient);
        // 改方法等同于  %   就是取余
        int i = Math.floorMod(100, 3);
        System.out.println(i);
        floorMod(100, 3);
        System.out.println("\u03c0");
        // 使用math类的方法可以有效避免数学运算中的运行错误仍能继续执行.  比如10亿*3  整数类型就会计算得到一个负数,而使用math类就会报错  提醒开发者
        // 乘法
        System.out.println(multiplyExact(2, 3));
        // 自增1
        incrementExact(2);
        int xkjla = 0100_1000_100;
        System.out.println(xkjla);
        // 位运算  & 都为1才是1  否则就是0
        // 位运算  | 都为0才是1, 否则就是1
        // 位运算  ~ 所有位取反, 包括符号位
        // 位运算  ^ 相同是0,否则就是1
        if ((i & 1) == 0) {
            // 判断奇偶数
        }

        /**
         * 这个就神奇了,用来替代临时变量  比如说排序
         * // a = a + b;
         * // b = a - b;
         * // a = a - b;
         *
         *
         * 这个也是用来替代临时变量   比如排序
         * a ^= b;
         * b ^= a;
         * a ^= b;
         */
        // 取余   比如说我们要让a对16进行取余，那么就可以让 a & 15 得出来的结果就是余数。
        // 取余操作只能针对位上数字都是1的单数


    }
}
