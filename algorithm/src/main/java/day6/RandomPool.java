package day6;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计一种结构，在该结构中有如下三个功能：
 * insert(key)：将某个key加入到该结构，做到不重复加入。
 * delete(key)：将原本在结构中的某个key移除。 getRandom()：
 * 等概率随机返回结构中的任何一个key。
 * 【要求】 Insert、delete和getRandom方法的时间复杂度都是
 * O(1)
 */
public class RandomPool<K> {
    private Map<K,Integer> map1;
    private Map<Integer,K> map2;
    private int size;
    public RandomPool(){
        map1 = new HashMap <>();
        map2 = new HashMap <>();
        size = 0;
    }
    public void insert(K key){
            if (!map1.containsKey(key)){
            map1.put(key,size);
            map2.put(size,key);
            size ++;
        }
    }
    public void delete(K key){//要把key所在的记录删除
        if (map1.containsKey(key)) {
            int deleteIndex = map1.get(key);//map1把要删除的记录的key拿出来
            int lastIndex = --size;
            K lastKey = map2.get(lastIndex);//map2把最后一个位置的key拿出来
            //把最后一个位置的key填到要删除的key的位置上
            map1.put(lastKey,deleteIndex);
            map2.put(deleteIndex,lastKey);
            //删除key记录
            map1.remove(key);
            //删除掉最后一个记录
            map2.remove(lastIndex);

        }
    }
    public K getRandom(){
        if (size == 0){
            return null;
        }
        int randomIndex = (int) (Math.random() * size);//等概率的在0~size-1的位置返回一个
        return map2.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomPool<String> pool = new RandomPool<String>();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
    }
}
