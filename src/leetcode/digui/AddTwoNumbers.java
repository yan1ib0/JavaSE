package leetcode.digui;

import leetcode.linklist.ListNode;

import java.util.List;

/**
 * @author Excalibur
 * @date 2022/3/24 12:42
 * @IDE IntelliJ IDEA
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        ListNode l2=new ListNode(5);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(9);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        l2.next.next.next=new ListNode(9);
        ListNode node = new AddTwoNumbers().addTwoNumbers(l1, l2);
        System.out.println(node);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        return helper(l1, l2, res, 0);
    }
    private ListNode helper(ListNode l1,ListNode l2,ListNode res,int mod){
        if (l1==null&&l2==null){
            if (mod==1)
             res=new ListNode(1);
            return res;
        }else if(l2==null){
            int sum=l1.val+mod;
            res=new ListNode(sum%10);
           res.next= helper(l1.next, l2, res.next,sum/10);
        }else if (l1==null){
            res=helper(l2, l1, res,mod);
        }else {
            int sum=l1.val+ l2.val+mod;
            res=new ListNode(sum%10);
            res.next=helper(l1.next, l2.next, res.next,sum/10);
        }
        return res;
    }
}
