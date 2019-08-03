package day7;

/**
 * 求n的阶乘
 */
public class Factoral {
    //递归方式
    public static long getfactorial1(int n){
        if (n ==1 ){
            return 1L;
        }
        return (long)n * getfactorial1(n-1);
    }
    //非递归方式
    public static long getFactrial2(int n){
        long result = 1L;
        for (int i = 1; i <= n;i++){
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(getfactorial1(n));
        System.out.println(getFactrial2(n));
    }

}
