package leetcode.linklist;

import java.util.List;

/**
 * @author Excalibur
 * @date 2022/3/13 14:06
 * @IDE IntelliJ IDEA
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null)return null;
        ListNode f=new ListNode(-1,head);
        ListNode l=new ListNode(-1,head);
        for (int i = 0; i <n ; i++) {
            f=f.next;
        }
        while(f.next!=null){
            f=f.next;
            l=l.next;
        }
        if (l.next==head)
            head=head.next;
        l.next=l.next.next;
        return head;
    }
}
