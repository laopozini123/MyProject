package com.why;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ：why
 * @description：
 * @version:
 */
public class Test {

    private static int[] twoNumbers;

    public static void main(String[] args) {
        twoNumbers = twoNumbers(new int[]{1, 22, 33, 44, 55, 66, 77, 88, 9}, 10);
        System.out.println(Arrays.toString(twoNumbers));
    }

    private static int[] twoNumbers(int[] ints, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ints.length; i++) {
            int result = key - ints[i];
            if (map.containsKey(result)) {
                return new int[]{i, map.get(result)};
            }
            map.put(ints[i], i);
        }
        throw new IllegalArgumentException("has no two nums solution");
    }
}
