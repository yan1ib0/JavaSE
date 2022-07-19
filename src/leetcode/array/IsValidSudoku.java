package leetcode.array;

/**
 * @author Excalibur_yan
 * @date 2022/3/11 12:17
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int length=board.length;
        int[][] row=new int[length][length];
        int[][] column=new int[length][length];
        int[][] sudoku=new int[length][length];
        for (int i = 0; i <length ; i++)
            for (int j = 0; j <length ; j++) {

                if (board[i][j] == '.')
                    continue;

                int num = board[i][j] - '0' - 1;
                //k是第几个单元格，9宫格数独横着和竖着都是3个单元格
                int k = i / 3 * 3 + j / 3;
                //如果当前数字对应的行和列以及单元格，只要一个由数字，说明冲突了，直接返回false。
                //举个例子，如果line[i][num]不等于0，说明第i（i从0开始）行有num这个数字。
                if (row[i][num] != 0 || column[j][num] != 0 || sudoku[k][num] != 0)
                    return false;
                //表示第i行有num这个数字，第j列有num这个数字，对应的单元格内也有num这个数字
                row[i][num] = column[j][num] = sudoku[k][num] = 1;


            }
        return true;
    }
}
