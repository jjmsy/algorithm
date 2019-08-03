package day4;

/**
 * 之子型打印矩阵，额外空间复杂度为O(1)
 */
public class ZigZagMatrix {
    public static void printMartixZigZag(int[][] matrix){
        int ar = 0;
        int ac = 0;
        int br = 0;
        int bc = 0;
        int endR = matrix.length -1;//最后一行
        int endC = matrix[0].length -1;//左后一列
        boolean flag = false;//判定从下开始打印还是从上开始打印
        while(ar != endR +1) {//没到最后一个数
            printLevel(matrix, ar, ac, br, bc, flag);
            ar = ac == endC ? ar + 1 : ar;//A如果到最后一列，换行
            ac = ac == endC ? ac : ac + 1;//A如果到最后一列，列不动
            bc = br == endR ? bc + 1 : bc;
            br = br == endR ? br : br + 1;
            flag = !flag;
        }
    }
    public static void printLevel(int[][] arr,int ar,int ac,int br,int bc,boolean flag){
        if (flag){
            while (ar != br +1){
                System.out.print(arr[ar++][ac--]+" ");
            }
        }else {
            while(br != ar-1){
                System.out.print(arr[br--][bc++]+ " ");
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMartixZigZag(matrix);

    }
}
