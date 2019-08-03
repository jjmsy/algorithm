package hard1;

/**
 * Manacher算法，求一个字符串的最长回文子串的长度，时间复杂度为O（n）
 */
public class Manacher {
    public static char[] manacherString(String str){
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 +1];
        int index = 0;
        for (int i = 0; i != res.length ;i++){
            res[i] = (i & 1) ==0 ? '#' : charArr[index ++];
        }
        return res;
    }
    public static int maxLcpsLength(String str){
        if (str == null || str.length() == 0){
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];//回文半径数组
        int C = -1;//取得最有边界的时候的回文中心
        int R = -1;//最右回文区域
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++){//求每一个i位置的回文中心
            //2*C-i就是i`对应的位置，R>i是i在回文区域的里面
            pArr[i] = R > i ? Math.min(pArr[2 * C -i],R -i) : 1;//i`的回文和我到R的距离哪个小那个就成为回文的区域
            while(i + pArr[i] < charArr.length && i-pArr[i] > -1){//左边和右边都不越界
                if (charArr[i + pArr[i]] == charArr[i- pArr[i]]){//如果扩出来的两个值相等
                    pArr[i]++;//回文半径++
                }else {
                    break;
                }
            }
            //更新R和C
            if (i + pArr[i] > R){//如果扩出来的区域超过了回文右边界
                R = i + pArr[i];//R成为新的回文右边界
                C = i;//i成为新的回文右边界的中心
            }
            max = Math.max(max, pArr[i]);//记录全局最大值
        }
        return max -1;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
    }
}
