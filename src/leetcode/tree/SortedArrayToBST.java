package leetcode.tree;

/**
 * @author Excalibur
 * @date 2022/3/17 23:53
 * @IDE IntelliJ IDEA
 * 分治 有序数组转二叉搜索树
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return tobst(nums, 0, nums.length - 1);
    }

    private TreeNode tobst(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = tobst(nums, start, mid - 1);
        root.right = tobst(nums, mid + 1, end);
        return root;
    }

}
