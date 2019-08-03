package solution3;

import java.util.HashMap;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class CloneNode {
    public static class Node {
        int value;
        Node next = null;
        Node rand = null;

        Node(int label) {
            this.value = label;
        }
    }
    public static Node clone(Node pHead) {
        if (pHead == null) {
            return null;
        }
        HashMap <Node, Node> map = new HashMap <>();
        Node newNode = pHead;
        while (newNode != null) {
             /**把cur和对应的拷贝节点放到map里面去
		        链表中遍历的每一个节点都拷贝到他的新节点
                newNode是此时在原链表中遍历到的节点，new Node就是生成了他的拷贝节点
		     */
            map.put(newNode, new Node(newNode.value));
            newNode = newNode.next;
        }
        newNode = pHead;
        while (newNode != null) {
            //newNode的拷贝节点指向的等于newNode指向的节点的拷贝节点
            map.get(newNode).next = map.get(newNode.next);
            //newNode的拷贝节点的rand指针指向的是newNode节点的random指针指向的节点的拷贝节点
            map.get(newNode).rand = map.get(newNode.rand);
            newNode = newNode.next;
        }
        return map.get(pHead);
    }
    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
       // Node res2 = null;
        printRandLinkedList(head);
        res1 = clone(head);
        printRandLinkedList(res1);
       // res2 = copyListWithRand2(head);
       // printRandLinkedList(res2);
       // printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = clone(head);
        printRandLinkedList(res1);
        //res2 = copyListWithRand2(head);
       // printRandLinkedList(res2);
        //printRandLinkedList(head);
        System.out.println("=========================");

    }
}
