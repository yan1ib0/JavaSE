package leetcode.tree;
/**
 * @author Excalibur
 * @date 2022/3/13 13:00
 * @IDE IntelliJ IDEA
 */
public class IsSymmetric {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isMirror(root.left, root.right);
	}

	private boolean isMirror(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null || left.val != right.val)
			return false;
		return isMirror(left.left,right.right)&&isMirror(left.right, right.left);
	}
}
