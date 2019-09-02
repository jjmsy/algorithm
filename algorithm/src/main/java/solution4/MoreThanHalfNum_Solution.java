package solution4;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum_Solution {
    public static int moreThanHalfNUm_Solution(int[] array) {
        if (array == null) {
            return 0;
        }
        if (array.length < 2) {
            return array[0];
        }
        int size = array.length / 2;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length ; i++) {
            if (!map.containsKey(array[i])){
                map.put(array[i],1);
            }else {
                int count = map.get(array[i]);
                map.put(array[i], ++count);
                if (count > size){
                    return array[i];
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(moreThanHalfNUm_Solution(arr));
    }
}
