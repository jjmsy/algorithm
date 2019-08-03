package day1;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void mergeSort(int arr[]){
        if (arr == null || arr.length < 2){
            return;
        }
        sortProcess(arr,0,arr.length - 1);
    }
    public static void sortProcess(int[] arr, int L, int R){
        if (L == R){
            return;
        }
        int mid = L + ((R - L) >> 1);//L和R重点的位置,等同于(L + R) /2
        sortProcess(arr,L,mid);//T(n /2)
        sortProcess(arr,mid +1,R);//T(n /2)
        /**
         * L到mid已经排好序，mid+1到R已经排好序
         * 然后进入merge过程
         */
        merge(arr,L,mid,R);//O(n)
        //T(n) = 2T(n/2)+ O(n)
    }
    public static void merge(int[] arr, int L, int mid, int R){
        int[] help = new int[R - L +1];
        int i = 0;
        int p1 = L;//指向左侧部分的第一个数，相当于左侧部分的最小值
        int p2 = mid +1;//指向右侧部分的第一个数，相当于右侧部分的最小值
        //这个循环跳出来说明有一个已经越界了
        while (p1 <= mid && p2 <= R){
            //谁小填谁
           // help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            if (arr[p1] < arr[p2]){
                help[i] = arr[p1];
                i++;
                p1++;
            }else {
                help[i] = arr[p2];
                i++;
                p2++;
            }
        }
        //俩个必有且只有一个越界

        while (p1 <= mid){//p1没有越界，则将p1拷贝进help
            help[i++] = arr[p1++];
        }
        while (p2 <= R){//p2没有越界，则将p2拷贝尽help
            help[i++] = arr[p2++];
        }
        //将help数组的东西拷贝回arr
        for (i = 0; i < help.length; i++){
            arr[L + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,8,3,4,0,11,9,7};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
