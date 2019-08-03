package day4;

import java.util.Stack;

/**
 * 判断一个链表是否是回文数
 */
public class IsPalindromel {
    public static class Node{
        private int value;
        private Node next;
        public Node(int data){
            this.value = data;
        }
    }
    /**
     * 第一种方法，不考虑额外空间复杂度，用栈来完成
     */
    public static boolean StackPailind(Node head){
        Stack<Node> stack = new Stack <>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);//将数据放到栈
            cur = cur.next;
        }
        while (head != null) {
            if (head.next != stack.pop().next){//栈中弹出来的数据和元数据比对//如果发现不一样返回false
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 不使用栈的方法，额外空间复杂度为O(1)
     * @return
     */
    public static boolean isPailedrole(Node head){
        if (head == null || head.next == null){//只有一个数据
            return true;
        }
        Node n1 = head;//慢指针
        Node n2 = head;//快指针
        /**
         * 奇数的时候来到中点位置
         * 偶数的时候来到两个中点位置的前一个
         */
        while (n2.next != null && n2.next.next != null){//快指针一次走两步
            n1 = n1.next;//n1走到中间
            n2 = n2.next.next;//n2走到结尾
        }
        n2 = n1.next;//快指针指向右边的第一个节点
        n1.next = null;//中点的next =null
        Node n3 = null;
        /**
         * 将右半部得分逆序统一连到中点位置上
         */
        while (n2 != null){//快指针不为空
            n3 = n2.next;//保存下一个节点
            n2.next = n1;//转换下一个节点
            n1 = n2;//移动n1
            n2 = n3;//移动n2
        }
        n3 = n1;//保存最后一个节点
        n2 = head;//n2指向左边的第一个节点
        boolean res = true;
        while (n1 != null && n2 != null) { // check palindrome
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next; // left to mid
            n2 = n2.next; // right to mid
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) { // recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;

    }
}
