package com.why.MultipleCase;

import java.util.Random;
import java.util.Vector;

/**
 * @author ：why
 * @date ：Created in 2020/5/9 10:10
 * @description：多例
 * @version:
 */
public class MultipleCase {
    private static Vector<MultipleCase> list = new Vector<>();
    private MultipleCase(){}
   static  {
        list.add(new MultipleCase());
        list.add(new MultipleCase());
    }

    public static synchronized MultipleCase getInstance(){
        int size = list.size();
        Random random = new Random();
        int index = random.nextInt(size);
        return list.get(index);
    }
}
