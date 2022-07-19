package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Excalibur
 * @date 2022/3/17 23:34
 * @IDE IntelliJ IDEA
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> res= new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> a=new ArrayList<>();
            int nodeNum=queue.size();
            for(int i=0;i<nodeNum;i++){
                TreeNode treeNode=queue.poll();
                if (treeNode.left!=null)
                    queue.add(treeNode.left);
                if (treeNode.right!=null)
                    queue.add(treeNode.right);
                a.add(treeNode.val);
            }
            res.add(a);
        }
        return res;
    }
}
