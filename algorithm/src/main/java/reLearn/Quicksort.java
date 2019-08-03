package reLearn;

import java.util.Arrays;

/**
 * 快速排序
 */
public class Quicksort {
    public static void quickSort(int arr[]){
        if (arr == null || arr.length <2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }
    public static void quickSort(int[]arr,int left,int right){
        if (left <= right){
            int p[] = partition(arr,left,right);
            quickSort(arr,left,p[0]-1);
            quickSort(arr,p[1]+1,right);
        }
    }
    public static int[] partition(int[] arr,int left,int right){
        int less = left-1;
        int more = right;
        int current = left;
        while (current < more){
            if (arr[current] < arr[right]){
                swap(arr,++less,current++);
            }else if(arr[current] > arr[right]){
                swap(arr,--more,current);
            }else {
                current++;
            }
        }
        swap(arr,more,right);
        return new int[]{less +1,more};
    }
    public static void swap(int[] arr,int i, int j){
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
