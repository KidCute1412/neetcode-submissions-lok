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
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode cur = null;
        if (cur1.val <= cur2.val)
        {
            cur = cur1;
            cur1 = cur1.next;
        }
        else{
            cur = cur2;
            cur2 = cur2.next;
        }
        while(cur1 != null && cur2 != null)
        {
            if (cur1.val <= cur2.val)
            {
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }
            else{
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }
        while (cur1 != null)
        {
            cur.next = cur1;
            cur = cur1;
            cur1 = cur1.next;
        }
        while (cur2 != null)
        {
            cur.next = cur2;
            cur = cur2;
            cur2 = cur2.next;
        }
        return (list1.val <= list2.val ? list1 : list2);
    }
}