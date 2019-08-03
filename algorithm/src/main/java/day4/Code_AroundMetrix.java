package day4;

/**
 * 给定一个整型矩阵matrix，请按照转圈的方式打印它。
 * 例如:1   2   3   4
 *      5   6   7   8
 *      9   10  11  12
 *      13  14  15  16
 *      打印结果为：1，2，3，4，8，12，16，15，14，13，9，
 * 5，6，7，11， 10
 */
public class Code_AroundMetrix {
    public static void spiralOrderPrint(int[][] matrix) {
        int fR = 0;
        int fC = 0;
        int eR = matrix.length - 1;
        int eC = matrix[0].length - 1;
        while (fR <= eR && fC <= eC) {
            printEdge(matrix, fR++, fC++, eR--, eC--);
        }
    }

    public static void printEdge(int[][] m, int fR, int fC, int eR, int eC) {
        if (fR == eR) {
            for (int i = fC; i <= eC; i++) {
                System.out.print(m[fR][i] + ",");
            }
        } else if (fC == eC) {
            for (int i = fR; i <= eR; i++) {
                System.out.print(m[i][fC] + ",");
            }
        } else {
            int curC = fC;
            int curR = fR;
            while (curC != eC) {
                System.out.print(m[fR][curC] + " ");
                curC++;
            }
            while (curR != eR) {
                System.out.print(m[curR][eC] + " ");
                curR++;
            }
            while (curC != fC) {
                System.out.print(m[eR][curC] + " ");
                curC--;
            }
            while (curR != fR) {
                System.out.print(m[curR][fC] + " ");
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1 }, { 2 }, { 3 },
                { 4 },{5} };
        spiralOrderPrint(matrix);

    }
}
