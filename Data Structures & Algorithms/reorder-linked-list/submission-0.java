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
    public void reorderList(ListNode head) {
        // Intuition: Create a reversed linked list. And we just map each node in both lists in a zigzag order.
        int num = countNode(head);
        ListNode head2 = splitHalf(head, num / 2);
        head2 = reverseList(head2);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head != null && head2 != null)
        {
            cur.next = head;
            head = head.next;
            cur = cur.next;
            cur.next = head2;
            head2 = head2.next;
            cur = cur.next;
        }
        if (head != null) cur.next = head;
        if (head2 != null) cur.next = head2;
        head = dummy.next;
        // 2 4 6 8
        // 8 6 4 2 
    }
    public int countNode(ListNode head)
    {
        ListNode cur = head;
        int num = 0;
        while (cur != null)
        {
            cur = cur.next;
            num++;
        }
        return num;
    }
    public ListNode splitHalf(ListNode head, int num)
    {
        ListNode cur = head;
        for (int i = 0; i < num - 1; ++i)
        {
            cur = cur.next;
        }
        ListNode ans = cur.next;
        cur.next = null;
        return ans;
    }
    public ListNode reverseList(ListNode head)
    {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null)
        {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
