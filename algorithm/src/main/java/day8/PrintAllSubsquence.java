package day8;

/**
 * 打印字符串的全部子序列，包括空字符串
 */
public class PrintAllSubsquence {
    /**
     *i来到了数组的终止位置就是base case
     * @param str char类型的数组
     * @param i 已经推进到i位置
     * @param res 当前形成的字符串
     */
    public static  void printAllSub(char[] str,int i,String res){
        if (i == str.length){
            System.out.println(res);
            return;
        }
        printAllSub(str,i+1,res);//不要当前字符的路
        printAllSub(str,i+1,res + String.valueOf(str[i]));//要当前字符的路
    }

    public static void main(String[] args) {
        String test = "abc";
        printAllSub(test.toCharArray(),0,"");
    }
}
