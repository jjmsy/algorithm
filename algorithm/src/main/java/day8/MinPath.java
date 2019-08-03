package day8;

public class MinPath {
    public static int minPath(int matrix[][],int i, int j){
        if(i == matrix.length -1 && j == matrix[0].length -1){//已经到达了右下角的位置
            return matrix[i][j];
        }
        if (i == matrix.length -1){//已经到了最后一行，则最短路径为当前位置的下一个位置到最后一个位置的最短路径和加当前位置
            return matrix[i][j] + minPath(matrix,i,j +1);
        }
        if (j == matrix[0].length -1){//已经到了最后一列
            return matrix[i][j] + minPath(matrix,i +1,j);
        }
        int right = minPath(matrix,i,j +1);//往右走，右边位置到右下角的最短路径和
        int down = minPath(matrix,i +1,j);//往下走，下边位置到右下角的最短路径和
        return matrix[i][j] + Math.min(right,down);
    }
}
