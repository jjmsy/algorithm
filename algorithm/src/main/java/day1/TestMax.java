package day1;

/**
 * 在一个数组中找最大值，使用递归的方式
 */
public class TestMax {
    public static int getMax(int[] arr,int left,int right){
        int mid = (left + right) / 2;
        if (left == right){
            return arr[left];
        }
        int maxLeft = getMax(arr,left,mid);
        int maxRight = getMax(arr,mid +1,right);
        return Math.max(maxLeft,maxRight);
    }

    public static void main(String[] args) {
        int arr[] = {3,2,4,1};
        System.out.println(getMax(arr,0,arr.length-1));
    }
}
