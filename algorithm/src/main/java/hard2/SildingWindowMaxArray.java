package hard2;

import java.util.LinkedList;

/**
 * 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置，
 * 例如：数组为{4,3,5,4,3,3,6,7}，窗口大小为3时
 * [4,3,5]4  3 3 6 7 窗口中最大值为5
 * 4,[3,5,4 ] 3 3 6 7窗口中最大值为5，以此类推
 * 如果数组长度为n窗口大小为w，则产生n-w+1个窗口的最大值
 * 请实现一个函数，输入整形数组arr，窗口大小为w，
 * 输出：一个长度为n-w+1的数组res，res[i]表示每种窗口状态下的最大值
 * 以上述数组为例，结果返回值为[5,5,5,4,6,7]
 *
 */
public class SildingWindowMaxArray {
    public static int[] getMaxWindow(int[] arr,int w){
        if (arr == null || w<1 || arr.length < w){
            return null;
        }
        //LinkedList就是一个标准的双向链表
        //ArrayList是一个动态数组
        LinkedList<Integer> qmax = new LinkedList <>();
        int res[] = new int[arr.length - w +1];
        int index = 0;
        for (int i = 0; i < arr.length; i++){//i依次遍历数组中所有的数
            //双端队列不为空并且双端队列尾部存放的下标所代表的值小于等于当前值
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();//从尾部弹出
            }
            qmax.addLast(i);//当链表里面最后一个节点的值大于当前值，当前值加入到尾部
            if (qmax.peekFirst() == i - w){//L往右移动的操作，如果i-w等于当前双端链表的头部
                qmax.pollFirst();//双端裂变的头部弹出
            }
            if (i >= w-1){//如果窗口已经形成
                res[index ++] = arr[qmax.peekFirst()];//把当前的最大值收集到结果里去，然后返回
            }
        }
        return res;
    }
}
