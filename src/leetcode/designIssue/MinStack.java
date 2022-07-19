package leetcode.designIssue;


/**
 * @author Excalibur
 * @date 2022/3/19 14:04
 * @IDE IntelliJ IDEA
 */
public class MinStack {
    // 栈顶
    private ListNode head;
    public MinStack() {
    }

    public void push(int val) {
        if (isEmpty())
            head=new ListNode(val, val, null);
        else
            head=new ListNode(val, Math.min(head.min, val), head);
    }

    public void pop() {
        if (isEmpty())
            throw new IllegalStateException("栈为空……");
        head=head.next;
    }

    public int top() {
        if (isEmpty())
            throw new IllegalStateException("栈为空……");
        return head.val;
    }

    public int getMin() {
        if (isEmpty())
            throw new IllegalStateException("栈为空……");
        return head.min;
    }
    private boolean isEmpty(){
        return head==null;
    }
}
class ListNode {
    public int val;
    public int min;//最小值
    public ListNode next;

    public ListNode(int val, int min, ListNode next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
