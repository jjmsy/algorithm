package solution2;


/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {
    public static class ListNode{
        int val;
        ListNode next = null;
        public ListNode(int val){
            this.val = val;
        }
    }
    public ListNode merge(ListNode list1,ListNode list2) {
//        if (list1 == null){
//            return list2;
//        }
//        if (list2 == null){
//            return list1;
//        }
//        ListNode help = new ListNode(-1) ;
//        help.next = null;
//        ListNode root = help;
//
//        while (list1 != null && list2 != null){
//            if (list1.val > list2.val){
//                help.next  = list2 ;
//                help = list2;
//                list2 = list2.next;
//            }else {
//                help.next = list1;
//                help = list1;
//                list1 = list1.next;
//            }
//        }
//        if (list1 != null){
//            help.next = list1;
//        }
//        if (list2 != null){
//            help.next = list2;
//        }
//        return root.next;

        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = merge(list1.next, list2);
            return list1;
        }else{
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }
}
