package hard1;

/**
 * 有一个str1和str2，要求找到str1的字串是否和str2一样，一样的返回str2的开始的位置
 */
public class KMP {
    public static int getIndexOf(String s,String m){
        if (s == null || m == null || s.length() <1 || m.length() < s.length()){
            return -1;
        }
        char[] str1 = s.toCharArray();//字符串变成字符类型的数组
        char[] str2 = m.toCharArray();
        int i1 = 0;//指向str1的下标
        int i2 = 0;//指向str2的下标
        int[] next = getNextArray(str2);
        while(i1 < str1.length && i2 < str2.length){
            if (str1 == str2){
                i1++;
                i2++;
            }else if(next[i2] == -1){//i2已经来到str2 0位置的字符了，说明第一个字符都和str1所指的字符配不上
                i1++;//str1指向下一个字符
            }else {
                i2 = next[i2];//能配上，继续往下匹配
            }
        }
        return i2 == str2.length ? i1 -i2 : -1;
    }
    //求当前下标的前缀和后缀的最长匹配和
    public static int[] getNextArray(char[] str2){
        if (str2.length ==1){
            return new int[]{-1};
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;//从下标为2开始求
        int cn = 0;//跳到的位置
        while(i < next.length){
            if (str2[i-1] == str2[cn]){//如果当前跳到的位置和前一个字符是一样的
                next[i++] = ++cn;//cn之前的长度为cn个//所以最长匹配和为cn+1

            }else if(cn >0){
                cn = next[cn];//往前跳一个
            }else {
                next[i++] = 0;//如果一直跳到0位置都没有匹配，最长匹配和为0
            }
        }
        return next;
    }
    public static void main(String[] args) {
        String str1 = "abc123def";
        String str2 = "123d";
        System.out.println(str1.indexOf(str2));
    }
}
