package day6;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个字符串类型的数组strs，找到一种拼接方式，使得把所
 * 有字 符串拼起来之后形成的字符串具有最低的字典序。
 */
public class LowestLexicography {
    public static class Mycomparator implements Comparator<String> {
        public int compare(String a,String b) {
            return (a + b).compareTo(b + a);//例如"ba"和"b"两个字符串，"bba"和"bab"比较，"bab"小，"ba"放前面
        }
    }
    public static String LoestString(String[] strs){
        if (strs == null || strs.length ==0){
            return "";
        }
        Arrays.sort(strs,new Mycomparator());
        StringBuilder res = new StringBuilder();
        for (int i = 0; i<strs.length; i++){
            res.append(strs[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"ba","c","b","a"};
        System.out.println(LoestString(strs));
    }
}
