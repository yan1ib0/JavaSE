package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Excalibur_yan
 * @date 2022/3/8 12:09
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for(int i = 0, j = 0; i < nums1.length && j < nums2.length;){
        /*
            首先对两个数组进行排序，然后使用两个指针遍历两个数组。
            初始时，两个指针分别指向两个数组的头部。
            每次比较两个指针指向的两个数组中的数字，如果两个数字不相等，则将指向较小数字的指针右移一位，
            如果两个数字相等，将该数字添加到答案，并将两个指针都右移一位。当至少有一个指针超出数组范围时，遍历结束。*/
            //第一个数组的第i个元素小于第二个数组的第j个元素
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int len = list.size();
        int[] ans = new int[len];
        for(int i = 0; i < len; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
