package day5;

/**
 * 判断一棵树是否是一颗平衡二叉树
 */
public class IsBalancedTree {
    public static class Node{
        public int value;
        public Node left;
        public Node rigtht;
        public Node(int data){
            this.value = data;
        }
    }
    public static class ReturnData{
        public boolean isB;//判断是否为平衡二叉树
        public int hight;//判断高度
        //初始化
        public ReturnData(boolean isB,int hight){
            this.isB = isB;
            this.hight = hight;
        }
    }

    public static boolean isB(Node head){
        return process(head).isB;//返回是否为平衡树
    }

    public static ReturnData process(Node head){
        if (head == null){
            return new ReturnData(true,0);
        }
        ReturnData leftData = process(head.left);//拿到左树的节点
        if (!leftData.isB){//如果左树不平衡，则整个树都不平衡
            return new ReturnData(false,0);
        }
        ReturnData rightData = process(head.rigtht);
        if (!rightData.isB){//如果右树不平衡，则整个树都不平衡
            return new ReturnData(false,0);
        }
        if (Math.abs(leftData.hight - rightData.hight) >1){//左树高度和右树高度的差值大于一，则不是平衡树
            return new ReturnData(false,0);
        }
        //左树高度和右树高度的最大值+1就是整个树的高度
        return new ReturnData(true,Math.max(leftData.hight,rightData.hight)+1);
    }
}
