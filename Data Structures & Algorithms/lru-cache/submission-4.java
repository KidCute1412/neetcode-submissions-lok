class LRUCache {
    Node head;
    Node end;
    int cap = 0;
    int curCap = 0;
    Map<Integer , Node> map; // key - {key - value}
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key))
        {
            // Need to move this node to the end (newest used)
            Node cur = map.get(key);
            moveToEnd(cur);
            return cur.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key))
        {
            Node cur = map.get(key);
            cur.val = value;
            moveToEnd(cur);
            return;
        }
        Node newNode = new Node(key, value);
        if (head == null)
        {
            head = newNode;
            end = newNode;
        }
        else{
            end.next = newNode;
            newNode.prev = end;
            newNode.next = null;
            end = newNode;
        }
        map.put(key, newNode);
        curCap++;
        if (curCap > cap)
        {
            curCap = cap;
            // remove head;
            Node tmp = head.next;
            map.remove(head.key);
            head = tmp;
            head.prev = null;
        }
        
    }
    public void moveToEnd(Node cur)
    {
        if (cur == end) return;
        if(cur.prev != null) cur.prev.next = cur.next;
        else{
            head = head.next;
            head.prev = null;
        }
        if (cur.next != null) cur.next.prev = cur.prev;
        end.next = cur;
        cur.prev = end;
        cur.next = null;
        end = end.next;
    }
}


class Node{
    int key;
    int val;
    Node prev;
    Node next;
    Node(int k, int value)
    {
        this.key = k;
        this.val = value;
    }
}