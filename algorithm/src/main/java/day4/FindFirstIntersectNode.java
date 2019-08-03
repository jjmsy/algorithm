package day4;

/**
 * 找到两个链表第一个相交的节点
 */
public class FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);//得到第一个链表的第一个入环节点
        Node loop2 = getLoopNode(head2);//得到第二个链表的第一个入环节点
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);//两个无环链表的相交问题
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);//两个有环链表的相交问题
        }
        return null;//一个有环一个无环不可能相交
    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next; // n1 -> slow 慢指针一次走一步
        Node n2 = head.next.next; // n2 -> fast 快指针一次走两步
        while (n1 != n2) {  //快指针和慢指针在环中相遇的时候停
            if (n2.next == null || n2.next.next == null) {
                return null;    //如果快指针提前走到结尾，不可能有环
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head; // n2 -> walk again from head  快指针回到头节点
        while (n1 != n2) {  //再次相交的时候即是第一个入环的节点
            n1 = n1.next;
            n2 = n2.next;//两个指针现在 都走一步
        }
        return n1;
    }

    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;//n代表两个链表长度的差值关系
        while (cur1.next != null) {//head1遍历，链表一的最后一个节点
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {//head2遍历，链表二的最后一个节点
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {//如果他俩最后一个节点不相等，不可能相交
            return null;
        }
        cur1 = n > 0 ? head1 : head2;//长链表的头部变为cur1指的东西
        cur2 = cur1 == head1 ? head2 : head1;//短链表的头部变为cur2指的东西
        n = Math.abs(n);
        while (n != 0) {//长链表先走n步
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {//长链表和短链表一起走，相遇的时候返回
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {//第二个拓扑结构，变成两个无环单链表相交问题
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {//如果转了一圈还没发现loop2则不相交
                if (cur1 == loop2) {//如果发现loop2，返回
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
//
//        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4
//
//        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);
//
//        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
