package sort;

import java.util.Arrays;
import java.util.Random;

import static leetcode.Util.swap;

/**
 * @author Excalibur
 * @date 2022/3/23 21:41
 * @IDE IntelliJ IDEA
 * 快排 O(Lgn)
 */
public class QuickSort {
    public static void main(String[] args) {
        Random rd = new Random();
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = rd.nextInt(100)+1;
        }
        System.out.println(Arrays.toString(num));
        sort(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
    }

    private static void sort(int[] nums,int start,int end) {
        if (start < end) {
            int index = patition(nums, start, end);
            sort(nums, start, index - 1);
            sort(nums, index + 1, end);
        }
    }
    public static int patition(int n[], int start, int end) {
        // p为基数，即待排序数组的第一个数
        int pivot = n[start];
        int i = start;
        int j = end;
        while (i < j) {
            // 从右往左找第一个小于基数的数
            while (n[j] >= pivot && i < j) {
                j--;
            }
            // 从左往右找第一个大于基数的数
            while (n[i] <= pivot && i < j) {
                i++;
            }
            // 找到后交换两个数
            swap(n, i, j);
        }
        // 使划分好的数分布在基数两侧
        swap(n, start, i);
        return i;
    }

}
