package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Excalibur
 * @date 2022/3/21 18:22
 * @IDE IntelliJ IDEA
 * 双指针处理
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i <nums.length-2 ; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            if (nums[i] > 0)
                break;
            int sum=-nums[i];
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                if(sum==(nums[l]+nums[r])){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r&&nums[l]==nums[l+1])
                        l++;
                    while(l<r&&nums[r]==nums[r-1])
                        r--;
                    l++;
                    r--;
                 //如果不行 指针移动
                } else if (sum>(nums[l]+nums[r])) {
                    l++;
                }else {
                    r--;
                }
            }
        }
        return res;
    }
}
