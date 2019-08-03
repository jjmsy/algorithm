package reLearn;

/**
 * 荷兰国旗问题
 */
public class HeLanGuoQi {
    public static int[] partition(int arr[],int left,int right,int num){
        int less = left -1;//小于区域
        int more = right +1;//大于区域
        int current = left;//数组的第一个数
        while (current < more){
            if (arr[current] < num){
                swap(arr,++less,current++);
            }else if(arr[current] > num){
                swap(arr,--more,current);
            }else {
                current++;
            }
        }
        return new int[]{less +1,more -1};
    }
    public static void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
