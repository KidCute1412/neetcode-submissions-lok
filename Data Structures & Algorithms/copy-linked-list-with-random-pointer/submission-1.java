/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // This problem is weird...
        // Topics are HashTable and Linked List
        // So I guess the approach is that we should create a hash key-value with key is the original node, value is the new node. So when we need to find the random element in a node, we should check the hash table.
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        Node cur1 = head;
        Node cur2 = dummy;
        while(cur1 != null)
        {
            // if the node was already created due to handling random
            if (!map.containsKey(cur1))
            {
                cur2.next = new Node(cur1.val);
            }
            else {
                cur2.next = map.get(cur1);
            }
           
            cur2 = cur2.next;
            map.put(cur1, cur2);
            
            // handle random element
            if (!map.containsKey(cur1.random))
            {
                if (cur1.random != null)
                {
                    cur2.random = new Node (cur1.random.val);
                }
                else
                    cur2.random = null;
                map.put(cur1.random, cur2.random);
            }
            else{
                cur2.random = map.get(cur1.random);
            }
            cur1 = cur1.next;
        }
        return dummy.next;
    }
}
