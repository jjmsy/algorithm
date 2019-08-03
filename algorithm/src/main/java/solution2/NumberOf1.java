package solution2;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *  java使用补码表示负数
 *  Integer.bitCount()方法用于统计二进制中1的个数。
 */
public class NumberOf1 {
    public static int numberOf1(int n){
        int res = 0;
        if (n == 0){
            return 0;
        }
        while(n != 0){
            ++ res;
            n = (n-1) & n;
        }
        return res;
    }
    public static int numberOfOne(int n){
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        int n = -1;
        System.out.println(numberOf1(n));
        System.out.println(numberOfOne(n));
    }
}
