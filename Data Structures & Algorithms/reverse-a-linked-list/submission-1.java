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
    public ListNode reverseList(ListNode head) {
        // Today is 18 / 9, still love DA
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null && cur.next != null)
        {
            prev = cur;
            cur = cur.next;
            if (prev == head) prev.next = null;
            else prev.next = head;
            head = prev;
        }
        if(cur != null) cur.next = prev;
        return cur;
    }
}
