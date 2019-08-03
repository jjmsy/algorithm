package solution2;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    public static class ListNode{
        int val;
        ListNode next = null;
        public ListNode(int val){
            this.val = val;
        }
    }
    public ListNode findKthToTail(ListNode head,int k) {
        if (head == null){
            return null;
        }if (head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode last = head;
        for (int i = 1;i < k; i++){
            if (pre.next != null){
                pre = pre.next;
            }else {
                return null;
            }
        }
        while(pre.next != null){
            pre = pre.next;
            last = last.next;
        }
        return last;
    }
}
