package leetcode.linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Excalibur
 * @date 2022/3/28 11:57
 * @IDE IntelliJ IDEA
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set=new HashSet<>();
        ListNode node=headA;
        while(node!=null){
            set.add(node);
            node=node.next;
        }
        node=headB;
        while(node!=null&&!set.contains(node)){
            node=node.next;
        }
        return node;
    }
}
