package leetcode.dp;

/**
 * @author Excalibur
 * @date 2022/3/18 17:26
 * @IDE IntelliJ IDEA
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n < 3)
            return n;
        int prev = 1;
        int curr = 2;
        int sum = 0;
        for (int i = 2; i < n; i++) {
            sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return sum;
    }
}
