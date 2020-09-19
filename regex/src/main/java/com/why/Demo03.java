package com.why;

/**
 * @author ：why
 * @date ：Created in 2020/5/10 15:22
 * @description：
 * @version:
 */
public class Demo03 {
    public static void main(String[] args){
        String str = "s";
//        String regex = "[a-z&&[^aeiou]]";
//        String regex = "[a-z]&&[^aeiou]";
        String regex = "[[a-z]&&[^aeiou]]";
//        String regex = "[a-z&&[^aeiou]]";
//        String regex = "[a-z]";
        boolean b = str.matches(regex);
        System.out.println(b);
    }
}
