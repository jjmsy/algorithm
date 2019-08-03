package day2;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void heapSort(int[] arr){
        if (arr ==null || arr.length <2){
            return;
        }
        for (int i = 0; i < arr.length ; i++){
            heapInsert(arr,i);//0--i上插入
        }
        int heapSize = arr.length;//heapSize一开始等于数组的全部
        swap(arr,0,--heapSize);//最后位置上的数和0位置交换，交换完之后堆的大小-1
        while(heapSize > 0){
            heapify(arr,0,heapSize);//继续调出一个大根堆
            swap(arr,0,--heapSize);//继续交换，重复过程
        }
    }

    /**
     * 经历一个新节点加入进来并且往上调整的过程就是heapInsert过程
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr,int index){
        while (arr[index] > arr[ (index - 1) /2]){//如果子节点比父节点大
            swap(arr,index,(index -1) /2);//子节点和父节点进行交换
            index = (index -1) /2;//子节点来到父节点的位置继续向上判断
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     *0--（heapSize-1）的范围形成的堆，再往右认为越界
     * @param arr
     * @param index
     * @param heapSize 当整个完全二叉树的大小是整个数组的时候，heapSize就是数组的大小
     *                 但可能是0-i范围形成的一个完全二叉树，所以heapSize只是表示堆上一共有多少个数
     *                 可能和数组的个数没关系，但一定不会比整个数组大
     */
    public static void heapify(int[] arr,int index, int heapSize){
        int left = index * 2 +1;//左孩子
        while (left < heapSize){//如果左孩子的下标越界了，说明已经是叶节点了
            int largest = left +1 < heapSize && arr[left +1]>arr[left] //右孩子也不越界，并且右孩子的值比左孩子大
                    ? left +1
                    : left;
            /**
             * 左右孩子的最大值和自己比较，大的那个变为largest
             */
            largest = arr[largest] > arr[index] ? largest :index;
            /**
             * 如果根节点和孩子之间根节点是最大值，就不用向下沉了
             */
            if (largest ==index){
                break;
            }
            swap(arr,largest,index);//largest ！= index的时候，根节点与较大孩子的下标交换
            index = largest;//根节点变为了较大孩子的下标
            left  = index * 2 +1;//左孩子继续往下走，重复while
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,3,8,4,0,11,9,7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
