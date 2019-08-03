package hard2;

import java.util.LinkedList;

/**
 * 最大值减去最小值小于或等于num的子数组的数量
 * 题目:给定数组arr和整数num，共返回有多少个子数组满足如下情况：
 * max(arr[i...j])-min(arr-[i...j])<=num
 * max(arr[i...j])表示子数组arr[i...j]中的最大值，min([i...j])表示子数组中的最小值
 * 要求：如果数组长度为N，请事先时间复杂度为O(N)的解法。
 */
public class AllLessSubArray {
    //暴力方法 O(n^3)
    public static int getNum1(int[] arr, int num){
        int res = 0;//表示有多少个子数组满足情况
        for (int start = 0;start < arr.length; start++){
            for (int end = start;end < arr.length; end ++){
                if (isVailed(arr,start,end,num)){
                    res++;
                }
            }
        }
        return res;
    }
    public static boolean isVailed(int[] arr,int start,int end,int num){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++){
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        return max - min <= num;
    }

    //时间复杂度为O（N）的解法
    public static int getNum2(int []arr,int num){
        if (arr == null || arr.length == 0){
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList <>();//准备一个最小值的更新结构
        LinkedList<Integer> qmax = new LinkedList <>();//准备一个最大值的更新结构
        int start = 0;//开始位置
        int end = 0;//结束位置
        int res = 0;
        while (start < arr.length){
            //当start确定的时候，end扩到不能再扩，停
            while (end < arr.length){
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[end] ){//最小值结构更新
                    qmin.pollLast();
                }
                qmin.addLast(end);
                while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[end]){//最大值结构更新
                    qmax.pollLast();
                }
                qmax.addLast(end);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num){//不达标
                    break;
                }
                end ++;
            }
            if (qmin.peekFirst() == start){//最小值的更新结构看看下标过期了没有
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == start){//最大值的更新结构看看下标过期了没有
                qmax.pollFirst();
            }
            res+=end - start;//得到所有以start开头的子数组达标的数量
            start ++;//start往右走一步，换一个开头
        }
        return res;
    }

}
