package leetcode;

/**
 * @author Excalibur
 * @date 2022/3/23 15:05
 * @IDE IntelliJ IDEA
 */
public class Util {


    public static void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
}