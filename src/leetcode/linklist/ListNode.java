package leetcode.linklist;

/**
 * @author Excalibur
 * @date 2022/3/13 13:57
 * @IDE IntelliJ IDEA
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
