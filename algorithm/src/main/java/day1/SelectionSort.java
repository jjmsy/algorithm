package day1;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length - 1 ; i++){
            int minIndex = i;//规定i为当前最小值得下标
            for (int j = i +1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex]? j : minIndex;//找到两个数之间最小的数的下标
            }
            swap(arr,i,minIndex);//0--N-1上最小的数和0位置交换，1--N-1上最小的数和1位置交换。。。
        }
    }
    public static void swap(int arr[],int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5,8,3,4,0,11,9,7};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
