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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 20/9, still waiting for love and love her...
        // Common pitfall: I had an idea to traverse 2 linked list seperatedly, then store them in num1 and num2, plus them and split that outcome to create the result linked list.
        // But that can't be implemented, because length can be 100, we can't use integer to store it.
        // Approach: Traverse both linked list paralleledly, plus each node and have a memory to know whether we need to plus 1 in the next plus operation.
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        boolean plusOne = false;
        while (cur1 != null && cur2 != null)
        {
            int num = cur1.val + cur2.val;
            if (plusOne) num += 1;
            if (num >= 10) plusOne = true;
            else plusOne = false;
            ListNode newNode = new ListNode(num % 10);
            cur.next = newNode;
            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        // in case l1 is longer than l2
        while(cur1 != null)
        {
            int num = (plusOne ? cur1.val + 1 : cur1.val);
            plusOne = (num >= 10 ? true : false);
            ListNode newNode = new ListNode(num % 10);
            cur.next = newNode;
            cur = cur.next;
            cur1 = cur1.next;
        }
        // in case l2 is longer than l1
        while(cur2 != null)
        {
            int num = (plusOne ? cur2.val + 1 : cur2.val);
            plusOne = (num >= 10 ? true : false);
            ListNode newNode = new ListNode(num % 10);
            cur.next = newNode;
            cur = cur.next;
            cur2 = cur2.next;
        }
        // Final plus node 1 if possible
        if (plusOne)
        {
            cur.next = new ListNode(1);
        }
        return dummy.next;

    }
}
