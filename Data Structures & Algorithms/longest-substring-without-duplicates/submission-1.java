class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Approach: Using hasmap and sliding window
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int n = s.length();
        int max = 0;
        while (end < n && start <= end)
        {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            if (map.get(s.charAt(end)) == 1)
            {
                int tmp = end - start + 1;
                if (max < tmp)
                {
                    max = tmp;
                }
            }
            else{
                while (map.get(s.charAt(end)) != 1)
                {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    start++;
                }
            }
            end++;
        }
        return max;
    }
}
