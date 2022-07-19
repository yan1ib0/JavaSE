package leetcode.array;

/**
 * @author Excalibur_yan
 * @date 2022/3/8 12:56
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
               if (nums[i]!=nums[index]){
                   nums[i]^=nums[index];
                   nums[index]^=nums[i];
                   nums[i]^=nums[index];
               }
                index++;
            }
        }
    }
}
