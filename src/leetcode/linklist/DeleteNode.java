package leetcode.linklist;

/**
 * @author Excalibur
 * @date 2022/3/13 13:56
 * @IDE IntelliJ IDEA
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
       node.val=node.next.val;
       node.next=node.next.next;
    }
}
