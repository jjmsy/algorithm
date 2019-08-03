package reLearn;

import java.util.Arrays;

/**
 * 堆排序
 */
public class DuiPaiXu {
    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length;i++){
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while (heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }

    }
    public static void heapInsert(int[] arr, int index){//index为当前节点
        while(arr[index] > arr[(index - 1)/2]){
            swap(arr,index,(index - 1) /2);
            index = (index -1 )/2;//index变为父节点继续向上调整
        }
    }
    public static void heapify(int[] arr,int index,int heapSize){
        int left = index * 2 +1;
        while (left < heapSize){
            int lagest = left + 1 < heapSize && arr[left+ 1] > arr[left] ? left+1 : left;
            lagest = arr[lagest] > arr[index] ? lagest : index;
            if (lagest == index){
                break;
            }
            swap(arr,lagest,index);
            index = lagest;
            left = index * 2 + 1;
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {5,3,8,4,0,11,9,7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
