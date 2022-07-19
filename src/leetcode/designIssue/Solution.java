package leetcode.designIssue;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Excalibur
 * @date 2022/3/19 13:51
 * @IDE IntelliJ IDEA
 * 设计打乱数组的函数
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution=new Solution(new int[]{1,2,3});
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }

    int[] nums;
    Random rnd = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] res=nums.clone();
        for (int i = 1; i<res.length; i++) {
            int d=rnd.nextInt(res.length);
            if (d==i)
                continue;
            res[d]^=res[i];
            res[i]^=res[d];
            res[d]^=res[i];
        }
        return res;
    }


}
