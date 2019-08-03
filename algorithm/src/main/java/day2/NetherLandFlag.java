package day2;

/**
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的
 * 左边，等于num的数放在数组的中间，大于num的数放在数组的
 * 右边。
 */
public class NetherLandFlag {
    public static int[] partation(int[] arr, int L, int R, int num){
        int less = L - 1;
        int more = R + 1;
        int current = L;
        while(current < more){//在current和more区域还没撞上的情况下
            if (arr[current] < num){//current指向的数比num小，移到less区域
                swap(arr,++less,current++);
            }else if(arr[current] > num){//current指向的数比num大，移到more区域
                swap(arr,--more,current);//current不动，吧交换来的数继续和mun做比较
            }else {//num = current
                current++;//把current移到下一个位置
            }
        }
        return new int[]{less+1,more-1};//返回等于num的中间区域
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
