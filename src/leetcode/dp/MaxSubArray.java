package leetcode.dp;

/**
 * @author Excalibur
 * @date 2022/3/18 18:14
 * @IDE IntelliJ IDEA
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int prev=nums[0];
        int max=nums[0];
        for (int i = 1; i <nums.length; i++) {
            prev=Math.max(prev,0)+nums[i];
            max=Math.max(max, prev);
        }
        return max;
    }
}
