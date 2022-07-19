package leetcode.tree;
/**
 * @author Excalibur
 * @date 2022/3/13 13:00
 * @IDE IntelliJ IDEA
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
