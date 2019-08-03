package day4;

/**
 * 给定一个整型正方形矩阵matrix，请把该矩阵调整成
 * 顺时针旋转90度的样子。
 */
public class RoteteMatrix {
    public static void rotate(int[][] matrix){
        int tR = 0;//左上角的行号
        int tC = 0;//左上角的列号
        int dR = matrix.length -1;//右下角的行号
        int dC = matrix.length -1;//右下角的列号
        while (tR < dR){
            roteteEdge(matrix,tR++,tC++,dR--,dC--);
        }
    }
    public static void roteteEdge(int[][] m, int tR, int tC, int dR, int dC){
        int times = dC - tC;//矩阵的长度
        int temp = 0;
        /**
         * 1 2 3 4
         * 5 6 7 8
         * 9 10 11 12
         * 13 14 15 16
         */
        for (int i = 0; i != times;i++){//外层的旋转完了还要旋转里层，所以不能是<times
            temp = m[tR][tC + i];//先让1的位置空出来并保存1
            m[tR][tC + i] = m[dR - i][tC];//13到1的位置
            m[dR - i][tC] = m[dR][dC - i];//16到13的位置
            m[dR][dC - i] = m[tR + i][dC];//4到16的位置
            m[tR + i][dC] = temp;//1到4的位置

        }
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }
}
