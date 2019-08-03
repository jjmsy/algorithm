package sulotion;

import java.util.Scanner;

/**
 * 输入n， 求y1=1!+3!+...m!(m是小于等于n的最大奇数） y2=2!+4!+...p!(p是小于等于n的最大偶数)。
 */
public class JieCheng {
    public static int sortLL(int n){
        int res = 0;
        if (n == 1){
            return 1;
        }
        if (n >1){
            res =  n * sortLL(n-1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();
        int y1 = 0;
        int y2 = 0;
        for (int i = 2; i <= n; i = i+2){
            y2 += sortLL(i);
        }
        for (int i = 1; i <= n;i = i+2){
            y1 += sortLL(i);
        }
        System.out.println(y1+ " "+y2);
    }
}
