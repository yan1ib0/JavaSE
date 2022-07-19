package leetcode.tree;
/**
 * @author Excalibur
 * @date 2022/3/13 13:00
 * @IDE IntelliJ IDEA
 */
public class IsValidBST {
	public boolean isValidBST(TreeNode root) {
	    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isValidBST(TreeNode root,long max,long min) {
		if (root == null) {
			return true;
		}
	    if (root.val >= max || root.val <= min)
	        return false;
		return isValidBST(root.left,root.val,min)&&isValidBST(root.right,max,root.val);
	
	}
}
