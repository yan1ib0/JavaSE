package leetcode.tree;

import java.util.Arrays;

/**
 * @author Excalibur
 * @date 2022/3/18 13:49
 * @IDE IntelliJ IDEA
 * 存入nums1中返回
 */
public class Merge {
    public static void main(String[] args) {
        int[] nums = new int[]{2,0};
        new Merge().merge(nums, 1, new int[]{1}, 1);
        System.out.println(Arrays.toString(nums));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //判空
        if (n == 0)
            return;
        if (nums1.length == 0 || m == 0) {
            nums1.clone();
            for (int i = 0; i < n; i++)
                nums1[i] = nums2[i];
            return;
        }

        int i = m + n - 1;
        m--;
        n--;
        while (i >= 0) {
            if (n<0)
                return;
            if (nums1[m] > nums2[n]) {
                nums1[i] = nums1[m];
                if (m>0)
                    m--;
                else nums1[m]=Integer.MIN_VALUE;
            } else {
                nums1[i] = nums2[n];
                nums2[n] = Integer.MIN_VALUE;
                n--;
            }
            i--;
        }
    }
}
