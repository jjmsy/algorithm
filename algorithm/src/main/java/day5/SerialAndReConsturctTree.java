package day5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化和反序列化
 */
public class SerialAndReConsturctTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //序列化
    public static String preSerial(Node head) {
        if (head == null) {
            return "#!";//#代表null，！之前的数是每一个节点的数
        }
        String res = head.value + "!";
        res += preSerial(head.left);//左数得到的字符串
        res += preSerial(head.right);//右数得到的字符串
        return res;
    }

    //反序列化
    public static Node reconByPreString(String preStr) {
        String[] values = preStr.split("!");//通过！进行分割
        Queue <String> queue = new LinkedList <>();
        for (int i = 0; i != values.length; i++) {
            queue.offer(values[i]);
        }
        return reconByPreString(preStr);
    }

    public static Node reconPerOrder(Queue <String> queue) {
        String value = queue.poll();//从队列中拿出一个数
        if (value == "#") {//当前节点是空
            return null;
        }
        Node head = new Node(Integer.valueOf(value));//头节点消费这个value建出Node节点来
        head.left = reconPerOrder(queue);//整颗左子树交给递归过程消费这个队列
        head.right = reconPerOrder(queue);//整颗右子树交给递归过程消费这个队列
        return head;
    }
}
