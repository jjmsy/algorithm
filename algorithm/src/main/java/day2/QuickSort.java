package day2;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }
    public static void quickSort(int[] arr, int L, int R){
        if (L < R){
            swap(arr, L + (int) (Math.random() * (R - L +1)),R);//加上这一行就是随机快排
            int[] p = partition(arr,L,R);//等于区域的位置
            quickSort(arr,L,p[0]-1);//等于区域-1就是比x小的区域
            quickSort(arr,p[1]+1,R);//等于区域+1就是比x大的区域
        }
    }
    public static int[] partition(int[] arr,int L, int R){
        int less = L -1;
        int more = R;//大于区域就是x，即最后一项的值
        while(L < more){
            if (arr[L] < arr[R]){
                swap(arr,++less,L++);
            }else if (arr[L] > arr[R]){
                 swap(arr,--more,L);
            }else {
                L++;
            }
        }
        swap(arr,more,R);
        return new int[]{less+1,more};//找出等于区域的范围，长度为2，返回的是一堆x的左边界和右边界
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {5,3,8,4,0,11,9,7};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
