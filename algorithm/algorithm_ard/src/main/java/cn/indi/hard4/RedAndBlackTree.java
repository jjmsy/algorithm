package cn.indi.hard4;

import java.util.TreeMap;

/**
 * 红黑树是平衡搜索二叉树
 */
public class RedAndBlackTree {
    public static void main(String[] args) {
        TreeMap<Integer,String> treeMap = new TreeMap <>();
        /**
         * 红黑树的增删改查代价也是O(N)的，所以在使用的过程中如果只是想通过key得到value的操作
         * 优先用hashMap，如果希望你的key是按序组织的，并且频繁调用这种查询，选择TreeMap
         */
        treeMap.put(5,"guo");
        treeMap.put(10, "song");
        treeMap.put(25, "laownag");
        treeMap.put(15, "tao");
        treeMap.put(20, "yao");
        System.out.println(treeMap);//自动排序

        System.out.println(treeMap.containsKey(5));
        System.out.println(treeMap.get(5));
        /**
         * 以下操作hash表要做到都要O(n)的代价，而红黑树是O(logN)
         */
        System.out.println("-------------------------------------------------------------------");
        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());//返回最大的节点值，hash表只能遍历，O(logN)的代价hash表是O(n)
        System.out.println(treeMap.ceilingKey(21));//找到在这个树种刚比21大的数是什么
        System.out.println(treeMap.floorKey(12));//找到离12最近的较小的key
    }
}
