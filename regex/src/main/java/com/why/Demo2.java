package com.why;

/**
 * @author ：why
 * @date ：Created in 2020/5/10 15:12
 * @description：
 * @version:
 */
public class Demo2 {
    public static void main(String[] args) {
        String str = "13213546848";
        boolean isMobilePhoneNum = isMobilePhoneNum(str);
        System.out.println("是电话号码吗?" + isMobilePhoneNum);
    }

    public static boolean isMobilePhoneNum(String str) {
        String regex = "1[3578]\\d{9}";
        return str.matches(regex);
    }
}
