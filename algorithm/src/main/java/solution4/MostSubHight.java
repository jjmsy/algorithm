package solution4;

import java.util.Scanner;

public class MostSubHight {
    public static void main(String[] ags) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int h_i = 0;
        for (int i = 0; i < n; i++){
            h_i = sc.nextInt();
            arr[i] = h_i;
        }
        for (int i = 0; i < n; i++){
            for (int j = i + 1;j < n;j++){
                if (arr[i] > arr[j]){
                    swap(arr,i,j);
                }
            }
        }
        int min = Math.abs(arr[arr.length -1] - arr[0]);
        for(int i = 1; i < n - 1;i++){
            if (arr[arr.length - 1] - arr[i] < min){
                swap(arr,i,arr.length -1);
            }
            min = arr[arr.length - 1] - arr[0] > arr[i] - arr[i -1]
                    ?arr[arr.length - 1] - arr[0] : arr[i] - arr[i -1];
        }
        int max = Math.abs(arr[arr.length -1] - arr[0]);
        int i = 0;
        while (i < arr.length -1){
            max = max > arr[i+1] - arr [i] ? max : arr[i+1] - arr [i];
            i++;
        }
        System.out.println(max);
    }
    public static void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
