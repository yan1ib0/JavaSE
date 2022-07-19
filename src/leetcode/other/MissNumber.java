package leetcode.other;

/**
 * @author Excalibur
 * @date 2022/3/20 14:39
 * @IDE IntelliJ IDEA
 * 等差数列求和公式
 */
public class MissNumber {
    public int missingNumber(int[] nums) {
        int len=nums.length;
        int result=len*(len+1)/2;
        for (int num:nums) {
            result-=num;
        }
        return  result;
    }
}
