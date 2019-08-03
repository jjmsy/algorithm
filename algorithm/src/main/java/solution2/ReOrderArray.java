package solution2;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public static void reOrderArray(int [] array) {
        for (int i = 0; i < array.length;i++){
            for (int j = 0; j < array.length - i -1;j++){
                if (array[j] % 2 == 0 && array[j+1] % 2 ==1){
                    swap(array,j,j+1);
                }
            }
        }
    }
    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int array[] = {5,4,6,7,11,3,2,9};
        reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
}

