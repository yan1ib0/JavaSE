package leetcode.linklist;

import java.util.List;

public class IsPalindromeList {
    public boolean isPalindrome(ListNode head) {
        ListNode f=head;
        ListNode s=head;
        while(f!=null&&f.next!=null){
            f=f.next.next;
            s=s.next;
        }
        s=reverseList(s);
        f=head;
        while(f!=null&&s!=null){
            if(f.val!=s.val)
                return false;
            f=f.next;
            s=s.next;
        }

        return true;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null ||head.next==null)
            return head;
        ListNode node=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }
}
