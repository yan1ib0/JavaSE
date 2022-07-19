package leetcode.array;

/**
 * @author Excalibur_yan
 * @date 2022/3/11 12:46
 * @apiNote 矩阵旋转90度 上下交换 然后对角线交换
 */
public class RotateImg {
    public void rotate(int[][] matrix) {
        int length=matrix.length;
        int[] a;
        //上下交换
        for(int i=0;i<length/2;i++){
            a=matrix[i];
            matrix[i]=matrix[length-i-1];
            matrix[length-i-1]=a;
        }
        System.gc();
        //对角线交换
        int num;
        for (int i = 0; i <length; i++) {
            for (int j = i+1; j <length ; j++) {
                num=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=num;
            }
        }
    }
}
