package leetcode.linklist;

/**
 * @author Excalibur
 * @date 2022/3/28 11:36
 * @IDE IntelliJ IDEA
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd=head;
        ListNode oddCur=odd;
        ListNode even=head.next;
        ListNode evenCur=even;
        while(evenCur!=null&&evenCur.next!=null){
            oddCur.next=oddCur.next.next;
            evenCur.next=evenCur.next.next;
            oddCur=oddCur.next;
            evenCur=evenCur.next;
        }
        oddCur.next=even;
        return odd;

    }
}
