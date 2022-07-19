package leetcode.linklist;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode f=head;
        ListNode s=head;
        while(f!=null&&f.next!=null){
            f=f.next.next;
            s=s.next;
            if (s==f)return true;
        }
        return false;
    }
}
