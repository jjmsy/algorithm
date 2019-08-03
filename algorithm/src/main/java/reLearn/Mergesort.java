package reLearn;

import java.util.Arrays;

public class Mergesort {
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length <2 ){
            return;
        }
        processSort(arr,0,arr.length -1);
    }
    public static void processSort(int[] arr,int left,int right){
        if (left == right){
            return;
        }
        int mid = left + (right - left) /2;
        processSort(arr,left,mid);
        processSort(arr,mid +1,right);
        merge(arr,left,mid,right);
    }
    public static void merge(int[] arr,int left,int mid,int right){
        int[] help = new int[right - left +1];
        int i = 0;
        int p1 = left;
        int p2 = mid +1;
        while (p1 <= mid && p2 <= right){
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
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= right){
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length;i++){
            arr[left + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,4,0,11,9,7};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
