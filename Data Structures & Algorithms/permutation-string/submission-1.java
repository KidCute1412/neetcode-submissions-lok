class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Approach: sliding window with fixed size of s1.length(), traverse it in s2 and check fluency of each elements in the window
        int n1 = s1.length();
        int n2 = s2.length();
        int start = 0, end = n1 - 1;
        if (n2 < n1) return false;
        // Map to check fluency in s1
        Map<Character, Integer> map1 = new HashMap<>();
        for (char x : s1.toCharArray())
        {
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        }
        Map<Character, Integer> mapCheck = new HashMap<>();
        // Initial check in the fixed window
        for (int i = start; i <= end; ++i)
        {
            mapCheck.put(s2.charAt(i), mapCheck.getOrDefault(s2.charAt(i), 0) + 1);
        }
        if (mapCheck.equals(map1)) return true;
        while(end < n2 - 1)
        {
            end++;
            mapCheck.put(s2.charAt(start), mapCheck.getOrDefault(s2.charAt(start), 0) - 1);
            mapCheck.remove(s2.charAt(start), 0);
            mapCheck.put(s2.charAt(end), mapCheck.getOrDefault(s2.charAt(end), 0) + 1);
            start++;
            if (mapCheck.equals(map1)) return true;
        }
        return false;
        
    }
}
