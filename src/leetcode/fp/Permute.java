package leetcode.fp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Excalibur
 * @date 2022/3/23 14:44
 * @IDE IntelliJ IDEA
 * LeetCode 46. 全排列
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        fp(res,new ArrayList<>(),nums);
        return res;
    }
    //递归;
    private void fp(List<List<Integer>> res, List<Integer> integers, int[] nums) {
        if (integers.size()==nums.length){
            res.add(new ArrayList<>(integers));
            return;
        }
        for (int i = 0; i <nums.length ; i++) {
            if (integers.contains(nums[i]))
                continue;
            integers.add(nums[i]);
            fp(res, integers, nums);
            integers.remove(integers.size()-1);
        }
    }
    //迭代
    private void fp_for(){

    }






}
