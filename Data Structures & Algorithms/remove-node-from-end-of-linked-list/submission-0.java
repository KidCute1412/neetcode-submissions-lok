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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = countNodes(head);
        int index = length - n;
        if (index < 0) return head;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        cur.next = head;
        for (int i = 0 ; i < index; ++i)
        {
            cur = cur.next;
        }
        if (cur.next != null)
        {
            cur.next = cur.next.next;
        }
        return dummy.next;
        
    }
    public int countNodes(ListNode head)
    {
        ListNode cur = head;
        int num = 0;
        while(cur != null)
        {
            cur = cur.next;
            num++;
        }
        return num;
    }
}
