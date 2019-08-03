package day8;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
public class PrintListFromTailToHead {
    public ArrayList<Integer> ReverseList(ListNode head) {
        ArrayList<Integer> list = new ArrayList <>();
        ArrayList<Integer> list2 = new ArrayList <>();
        list.add(head.val);
        if (head.next == null){
            return list;
        }
        ListNode curr = head.next;
        while(curr != null){
            list.add(curr.val);
            curr = curr.next;
        }
        for (int i = list.size() -1; i >=0;i--){
            list2.add(list.get(i));
        }
        return list2;
    }
}
