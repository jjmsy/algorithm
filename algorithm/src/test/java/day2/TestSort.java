package day2;

import org.junit.Test;

import java.util.Arrays;

public class TestSort {
    @Test
    public void testHeapSort(){
        int[] arr = new int[]{4,2,3,8,6,9,0};
        System.out.println(Arrays.toString(arr));
        HeapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void testQuickSort(){
        int[] arr = new int[]{4,2,3,8};
        System.out.println(Arrays.toString(arr));
        QuickSort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void testThread(){
        Thread[] ths = new Thread[3];
        for (int i = 0; i < 3; i++){
            ths[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++){
                        System.out.println(j);
                    }
                    System.out.println(" ");
                }
            });
        }
        for (Thread th : ths){
            th.start();
        }
    }
    @Test
    public void testSum(){
        int a, b;
        for (a = 1, b = 1; a <= 100; a++) { if (b >= 20)
            break;
            if (b % 3 == 1) {
                b += 3;
                continue;
            }
            b -= 5;
        }
        System.out.println(a);
    }
}
