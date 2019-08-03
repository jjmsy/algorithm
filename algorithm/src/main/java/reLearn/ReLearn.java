package reLearn;

import java.util.Arrays;

public class ReLearn {
    /**
     * 冒泡排序法
     */
    public static void BubboSort(int[] arr){
        if (arr == null||arr.length == 0 ){
            return;
        }
        for (int i = arr.length -1; i >=0; i--){
            for (int j = 0;j < i; j++){
                if (arr[j] > arr[j +1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    /**
     *插入排序法
     */
    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2 ){
            return;
        }
        for (int i = 1;i < arr.length; i++){
            for (int j = i-1;j >= 0 && arr[j] > arr[j+1]  ;j--){
                swap(arr,j,j+1);
            }
        }
    }

    /**
     *选择排序
     */
    public static void selectSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        for (int i = 0; i < arr.length -1; i++){
            int minIndex = i;
            for (int j = i +1;j < arr.length; j++){
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5,8,3,4,0,11,9,7};
        //BubboSort(arr);
       // System.out.println(Arrays.toString(arr));
       // insertSort(arr);
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
