package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Excalibur
 * @date 2022/3/20 14:14
 * @IDE IntelliJ IDEA
 * 杨辉三角  动态规划
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> yh=new ArrayList<>();
        for (int i = 0; i <numRows ; i++) {
            List<Integer> row=new ArrayList<>();
            for (int j = 0; j <=i ; j++) {
                if (j==0||j==i)
                    row.add(1);
                else row.add(yh.get(i-1).get(j-1)+yh.get(i-1).get(j));
            }
            yh.add(row);
        }
        return yh;
    }
}
