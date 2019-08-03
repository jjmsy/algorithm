package day1;

import java.util.Arrays;

public class InsertionSort {
    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        /**
         * 0位置上的数是不动的，考察的是从1位置开始的i位置的数，
         * 可以理解为当前这个i位置上的数我要往前面的有序区里面插入了
         */
        for (int i = 1; i < arr.length; i++){
            /**
             * j位置上的数首先和j+1的数比较，等同于i-1与i比较，如果j比j+1大，则交换
             * 例：5，3，4，0，6    j位置为4，j+1位置为0，比较之后j与j+1交换，j-1
             * 交换后为5，3，0，4，6    此时j位置为3，j+1位置为0
             */
            for (int j = i-1; j >= 0 && arr[j] > arr[j+1]; j--){
                swap(arr,j,j+1);
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        //异或运算的交换方法，比较炫酷
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
        //上面的与下面的等价
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {2,10,5,3,4,0,6};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
