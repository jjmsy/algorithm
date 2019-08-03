package cn.indi.hard4;

import java.util.HashMap;

/**
 * 给定一个数组arr，和一个整数num，求在arr中，累加和等于num的最长 子数组的长度
 * 例子： arr = {7,3,2,1,1,7,7,7} num = 7 其中有很多的子数组累加和等于7，
 * 但是最长的子数组是{3,2,1,1}，所 以返回其长度4
 */
public class LongestSumSubArrayLength {
    public static int maxLength(int[] arr,int num){
        if (arr == null || arr.length == 0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap <>();
        map.put(0,-1);
        int len = 0;
        int sum  = 0;
        for (int i = 0; i < arr.length;i++){
            sum += arr[i];
            /**
             * 从0 开始查sum-num的累加和，查看是否出现过
             */
            if (map.containsKey(sum - num)) {
                len = Math.max(i - map.get(sum - num), len);//如果出现过，更新最大长度
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);//如果没出过，把这个值加进去
            }
        }
        return len;
    }
}
