package leetcode.tree;
/**
 * @author Excalibur
 * @date 2022/3/13 13:00
 * @IDE IntelliJ IDEA
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
