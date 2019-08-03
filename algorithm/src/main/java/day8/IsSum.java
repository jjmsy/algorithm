package day8;

/**
 * 给你一个数组arr，和一个整数aim，如果可以任意选择arr中的数字，能不能累加得到aim，返回true和false
 */
public class IsSum {
    /**
     *
     * @param arr 数组，固定不变
     * @param i 来到i位置
     * @param sum 已经形成的和是sum
     * @param aim 目标数，固定不变
     * @return
     */
    public static boolean isSum(int[] arr,int i, int sum,int aim){
        //base case
        if (i == arr.length){//如果i来到了最后的位置
            return sum == aim;
        }
        //中间可以要当前数或者不要当前数,两个只要有一个是true就是true
        return isSum(arr,i+1,sum + arr[i],aim) || isSum(arr,i+1,sum,aim);
    }
    public static boolean money2(int[] arr, int aim) {
        boolean[][] dp = new boolean[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][aim] = true;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + arr[i] <= aim) {
                    dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int [] arr = {3,2,5};
        int aim = 7;
        System.out.println(money2(arr,aim));
    }
}
