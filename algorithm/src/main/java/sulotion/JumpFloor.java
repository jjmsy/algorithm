package sulotion;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor {
    public static int jumpFloor(int target){
        if (target == 0 || target == 1 || target == 2){
            return target;
        }
        int n1 = 1;
        int n2 = 2;
        int res = 0;
        if (target > 2){
            for (int i = 2;i < target;i++){
                res = n1 + n2;
                n1 = n2;
                n2 = res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int target = 6;
        System.out.println(jumpFloor(target));
    }
}
