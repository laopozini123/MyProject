package com.why;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：why
 * @date ：Created in 2020/5/8 20:53
 * @description：
 * @version:
 */
public class TwoNums {
    public static void main(String[] args){
        int[] twoNumbers = twoNumbers(new int[]{1, 22, 33, 44, 55, 66, 77, 88, 9}, 10);
        System.out.println(Arrays.toString(twoNumbers));
    }

    private static int[] twoNumbers(int[] nums,int target){
        // 创建map集合存储数据
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 用目标值与数组内的值做减法得到一个result
            int complete = target - nums[i];
            // 拿着result去map中找是否含有result键的值,找到了就说明完成需求
            if (map.containsKey(complete))
                // 将当前索引和map根据key获取到的值(也就是数组中值的索引)返回
                return new int[]{i,map.get(complete)};
            // 如果没有,就把当前循环的数值和数值的索引存储到map中去
            map.put(nums[i],i);
        }
        // 循环结束还没有就抛出异常
        throw new IllegalArgumentException("has no two nums solution");
    }
}
