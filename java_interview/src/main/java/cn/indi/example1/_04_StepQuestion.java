package cn.indi.example1;

/**
 * 有n步台阶，一次只能上一步或者两步，一共有多少种走法？
 */
public class _04_StepQuestion {
    //递归的方法：
    //实现f（n）：求n步台阶 一共有几种走法
    public int f(int n) {
        if (n < 1) {
            throw new IllegalArgumentException(n + "不能小于1");
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return f(n - 1) + f(n - 2);
    }


}
