package day5;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap <>();
        map.put("Hello","world");
        map.put("Hello","hard");//如果出现重复的key，会把原来的value覆盖掉
        System.out.println(map);

    }
}
