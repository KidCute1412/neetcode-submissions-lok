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
        // 19/9.
        // The previous intuition requires 2 iterations, with the first one to count number of nodes, and the second on is to find the index of node need deleting. 
        // This intuition requires only 1 iterations. I use 2 pointers, name fast and slow. Maintain the difference right before the node need deleting.
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;
        // Create initial distance
        for (int i = 0; i < n + 1; ++i)
        {
            fast = fast.next;
        }
        while (fast != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
