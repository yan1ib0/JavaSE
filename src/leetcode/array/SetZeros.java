package leetcode.array;

import java.util.Arrays;

/**
 * @author Excalibur
 * @date 2022/3/21 20:18
 * @IDE IntelliJ IDEA
 */
public class SetZeros {
    public void setZeroes(int[][] matrix) {
        int[] row=new int[matrix.length];
        int[] col=new int[matrix[0].length];

        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for (int i = 0; i <row.length ; i++) {
            if (row[i]!=0) {
                matrix[i]=new int[matrix[0].length];
            }
        }
        for (int i = 0; i <col.length; i++) {
            if (col[i]!=0) {
                for (int j = 0; j <matrix.length ; j++) {
                    matrix[j][i]=0;
                }
            }

        }
    }
}
