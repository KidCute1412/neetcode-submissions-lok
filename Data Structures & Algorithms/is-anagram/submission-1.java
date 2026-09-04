class Solution {
    public boolean isAnagram(String s, String t) {
        // Approach 2, using fixed array to count
        // increment s, decrease t, if the all the final elements in array are 0, they are anagram
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i)
        {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int x : count)
        {
            if (x != 0)
                return false;
        }
        return true;
    }
}
