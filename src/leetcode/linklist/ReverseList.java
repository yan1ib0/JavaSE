package leetcode.linklist;

import java.util.List;

/**
 * @author Excalibur
 * @date 2022/3/13 14:50
 * @IDE IntelliJ IDEA
 *  递归 逆转链表
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null ||head.next==null)
            return head;
        ListNode node=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }
}
