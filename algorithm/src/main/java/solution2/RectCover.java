package solution2;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCover {
    public static int rectCover(int target){
        if (target == 0 || target == 1 || target ==2 || target ==3){
            return target;
        }
        int res = 0;
        if (target > 3){
            res =  rectCover(target-1) + rectCover(target -2);
        }
        return res;
    }

    public static void main(String[] args) {
        int target  = 5;
        System.out.println(rectCover(target));
    }
}
