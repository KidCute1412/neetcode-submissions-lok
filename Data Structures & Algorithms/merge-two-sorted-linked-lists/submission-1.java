/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // We don't need to create cur1 and cur2, just use directly list1 and list2. it will be more efficient in case of redundancy (when a list is longer than the other one)
        // Good approach: we can create a dummy node, because it will have next operation which a null node can't call
        ListNode dummy =  new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null)
        {
            if (list1.val <= list2.val)
            {
                cur.next = list1;
                list1 = list1.next;
            }
            else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 == null) // list2 may be longer
        {
            cur.next = list2;
        }
        else{
            cur.next = list1;
        }
        return dummy.next;
    }
}