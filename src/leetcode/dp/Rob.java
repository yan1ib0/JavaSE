package leetcode.dp;

/**
 * @author Excalibur
 * @date 2022/3/19 13:21
 * @IDE IntelliJ IDEA
 * 经典问题 打家劫舍
 */
public class Rob {
    public int rob(int[] nums) {
        int[][] dp=new int[nums.length][2];
        dp[0][0]=0;
        dp[0][1]=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=Math.max(dp[i-1][0]+nums[i],dp[i-1][1]);
        }
        return dp[nums.length-1][1];
    }
}
