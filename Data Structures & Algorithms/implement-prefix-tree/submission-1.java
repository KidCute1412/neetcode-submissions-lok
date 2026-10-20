class PrefixTree {
    // 20/10 I'm missing her too much and feel a little bit lazy to learn AWS, so back to NeetCode =')))
    // Notes: All characters are made of lowercase English letters. So we have 26 slots only.
    // Intuition: This data structure is a tree with each node contains an array of 26 letters. To search, just search from the root to the leaf. To find prefix, traverse and it doesn't require to reach the leaf.
    Node root;
    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        int len = word.length();
        Node cur = root;
        for (int i = 0; i < len; ++i)
        {
            if (cur.children == null) 
                cur.children = new Node[26];
            if (cur.children[word.charAt(i) - 'a'] == null)
            {
                cur.children[word.charAt(i) - 'a'] = new Node();
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {    
        int len = word.length();
        Node cur = root;
        for (int i = 0 ; i < len; ++i)
        {
            if (cur.children == null || (cur.children != null && cur.children[word.charAt(i) -'a'] == null)) return false;
            cur = cur.children[word.charAt(i) - 'a'];
        }
        if (cur.isEnd) return true;
        return false;
     }

    public boolean startsWith(String prefix) {
        int len = prefix.length();
        Node cur = root;
        for (int i = 0; i < len; ++i)
        {

            if (cur.children == null || (cur.children != null && cur.children[prefix.charAt(i) - 'a'] == null)) return false;
            cur = cur.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

class Node {
    boolean isEnd = false;
    Node[] children = null;
    public Node(){};
}