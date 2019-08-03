package day8;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class StringNullTo20 {
    public static String replaceSpace(StringBuffer str){
        String result = str.toString();
        if (result.contains(" ")){
            while(str.indexOf(" ") != str.lastIndexOf(" ")){
                int index = str.indexOf(" ");
                str.replace(index,index +1,"%20");
            }
            int index = str.indexOf(" ");
            str.replace(index, index + 1, "%20");
            result = str.toString();
            return result;
        }
        return result;
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.append("We Are Happy.");
        System.out.println(replaceSpace(str));
    }
}
