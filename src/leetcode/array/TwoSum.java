package leetcode.array;

import java.util.HashMap;

/**
 * @author Excalibur_yan
 * @date 2022/2/23 13:58
 */
public class TwoSum {
    public static void main(String[] args) {
        new TwoSum().twoSum(new int[]{2,7,11,15},9);
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                System.out.println(map.get(nums[i])+":"+i);
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target-nums[i], i);
            }
        }
        return new int[2];
    }
}
