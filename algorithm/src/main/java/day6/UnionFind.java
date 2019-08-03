package day6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 并查集结构
 */
public class UnionFind {
    public static class Node{
        //whatever you want
    }
    public static class UnionFindSet{
        public Map<Node,Node> fatherMap;//key：是某一个节点，value：是key对应的父节点是谁
        public Map<Node,Integer> sizeMap;//代表节点所在的集合一共有多少个节点
        public UnionFindSet(List<Node> nodes){
            makeStes(nodes);//初始化的时候把所有样本都加进来
        }
        public void makeStes(List<Node> nodes){
            this.fatherMap = new HashMap <>();
            this.sizeMap = new HashMap <>();
            for (Node node :nodes){
                fatherMap.put(node,node);//每一个节点都是自己的一个集合
                sizeMap.put(node,1);//只有一个元素，所以每一个元素都是自己的代表节点
            }
        }
        private Node findHead(Node node){//找代表节点
            //递归的方法
//            Node father = fatherMap.get(node);//拿到这个节点的父节点
//            if (father != node){//没有找到代表节点
//                father = findHead(father);//让father等于当前节点，继续向上找
//            }
//            fatherMap.put(node,father);//把沿途所有的节点都指向代表节点
//            return father;

            //非递归的方法
            Stack<Node> stack = new Stack <>();
            Node cur = node;//当前节点
            Node father = fatherMap.get(cur);
            while(cur != father){
                stack.push(cur);
                cur = father;
                father = fatherMap.get(cur);
            }
            if (!stack.isEmpty()){
                fatherMap.put(stack.pop(),father);//沿途所有集结点都连到代表节点
            }
            return father;

        }
        public boolean isSameSet(Node a,Node b){
            return findHead(a) == findHead(b);
        }
        public void union(Node a,Node b){
            if (a ==null || b==null){
                return;
            }
            Node ahead = findHead(a);//a的代表节点为ahead
            Node bhead = findHead(b);//b的代表节点为bhead
            if (ahead != bhead){
                int aSetSize = sizeMap.get(ahead);//得到a集合的节点个数
                int bSetSize = sizeMap.get(bhead);//得到b集合的节点个数
                if (aSetSize <= bSetSize){//a的节点个数小于b节点个数
                    fatherMap.put(ahead,bhead);//a集合连到b集合，a的代表节点的父节点现在变为bhead
                    sizeMap.put(bhead,aSetSize + bSetSize);//b集合增加a的节点个数
                }else {
                    fatherMap.put(bhead,ahead);//b集合连到a集合
                    sizeMap.put(ahead,aSetSize+bSetSize);//a集合增加b的节点个数
                }
            }
        }
    }
}
