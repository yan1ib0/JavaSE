package leetcode.linklist;

/**
 * @author Excalibur
 * @date 2022/3/13 15:19
 * @IDE IntelliJ IDEA
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null){
            return list2;
        }
        if (list2==null)
            return list1;

        if(list1.val>list2.val){
            list2.next=mergeTwoLists(list1, list2.next);
            return list2;
        } else{
            list1.next=mergeTwoLists(list1.next, list2);
            return list1;
        }
    }
}
