package solution3;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    ArrayList<Integer> list = new ArrayList <>();
    public ArrayList<Integer> printMatrix(int[][] matrix){
        int fR = 0;
        int fC = 0;
        int eR = matrix.length -1;
        int eC = matrix[0].length -1;
        while (fR <= eR && fC <= eC) {
            printEdge(matrix, fR++, fC++, eR--, eC--);
        }
        return list;
    }
    private void printEdge(int[][] matrix, int fR, int fC, int eR, int eC){
        if (fR == eR){
            for (int i = fC; i <= eC; i++){
                list.add(matrix[fR][i]);
            }
        }else if (fC == eC){
            for (int i = fR; i <= eR; i++){
                list.add(matrix[i][fC]);
            }
        }else {
            int curR = fR;
            int curC = fC;
            while (curC != eC){
                list.add(matrix[fR][curC]);
                curC++;
            }
            while(curR != eR){
                list.add(matrix[curR][eC]);
                curR++;
            }
            while (curC != fC){
                list.add(matrix[eR][curC]);
                curC--;
            }
            while (curR != fR){
                list.add(matrix[curR][fC]);
                curR --;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1 }, { 2}, { 3 },
                { 4},{5} };
        PrintMatrix a = new PrintMatrix();
       // a.printMatrix(matrix);
        System.out.println(a.printMatrix(matrix));
    }
}
