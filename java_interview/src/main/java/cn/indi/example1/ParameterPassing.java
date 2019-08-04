package cn.indi.example1;

import java.util.Arrays;

/**
 * 方法的参数传递
 */
public class ParameterPassing {
    public static void main(String[] args) {
        int i = 1;
        String str = "Hello";
        Integer num = 200;
        int[] arr = {1, 2, 3, 4, 5};
        MyData my = new MyData();
        change(i, str, num, arr, my);
        System.out.println("i = " + i);
        System.out.println("str = " + str);
        System.out.println("num = " + num);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("my.a = " + my.a);
    }

    public static void change(int i, String s, Integer n, int[] a, MyData m) {
        i += 1;
        s += "world";
        n += 1;
        a[0] += 1;
        m.a += 1;
    }
}

class MyData {
    int a = 10;
}
