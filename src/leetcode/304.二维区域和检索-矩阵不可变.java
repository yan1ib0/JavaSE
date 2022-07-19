/*
 * @lc app=leetcode.cn id=304 lang=java
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */

// @lc code=start
class NumMatrix {
    int[][] preNum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0)
            return;
        preNum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preNum[i][j] = preNum[i - 1][j] 
                    + preNum[i][j - 1] 
                    + matrix[i - 1][j - 1] 
                    - preNum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int r1, int c1, int r2, int c2) {
        return preNum[r2 + 1][c2 + 1] 
            - preNum[r1][c2 + 1] 
            - preNum[r2 + 1][c1] 
            + preNum[r1][c1];
    }

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end
