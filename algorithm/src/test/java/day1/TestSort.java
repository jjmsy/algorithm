package day1;


import org.junit.Test;

import java.util.Arrays;

public class TestSort {
    @Test
    public void testBobbleSort(){
        int[] arr = new int[]{4,2,3,8,6,9,0};
        BobbleSort.bobbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void testSelectionSort(){
        int[] arr = new int[]{4,2,3,8,6,9,0};
       SelectionSort.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void testSmallSum(){
        int[] arr = new int[]{1,3,4,2,5};
        System.out.println(LittleAdd.smallSum(arr));
    }

}
