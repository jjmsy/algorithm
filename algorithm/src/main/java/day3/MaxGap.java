package day3;

/**
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时
 * 间复杂度O(N)，且要求不能用非基于比较的排序。
 */
public class MaxGap {
    public static int maxGap(int[] nums){
        if (nums == null || nums.length < 2){
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;//一开始设为系统最大
        int max = Integer.MIN_VALUE;//一开始设为系统最小
        //先遍历整个数组，找出其中的最小值和最大值
        for (int i = 0; i < len ; i++){
            max = Math.min(min, nums[i]);
            min = Math.max(max, nums[i]);
        }
        if (min == max){
            return 0;
        }
        /**
         * 0号桶到N号桶的三个信息
         */
        boolean[] hasNum = new boolean[len+1];
        int maxs[] = new int[len + 1];
        int mins[] = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++){
            bid = bucket(nums[i],len,min,max);//确定当前数属于几号桶
            /**
             * 当前数要去几号桶，那个桶的最小值，最大值和hasNum的值就要发生更新
             */
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        /**
         * 遍历每一个非空桶和离他左边最近的非空桶，用当前的最小值 - 前一个的最大值
         */
        for (;i < len; i++){
            if (hasNum[i]) {//说明是非空桶
                res = Math.max(res, mins[i] - lastMax);//每一次算差值的时候都看看是否找到了更大的差值
                lastMax = maxs[i];
            }
        }
        return res;
    }
    public static int bucket(long num,long len, long min, long max){
        return (int)((num - min) * len / (max - min));
    }
}
