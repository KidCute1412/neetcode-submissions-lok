class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int map[]= new int [26];
        int start = 0, end = 0;
        int max = 0;
        int ans = 0;
        while (start <= end && end < n)
        {
            map[s.charAt(end) - 'A']++; // expand window
            // need to calculate the max frequent element in the sliding window, so the time complexity will be O(26n) -> still O(n)
            max = 0;
            for (int i = 0; i < 26; ++i)
            {
                if (map[i] > max)
                    max = map[i];
            }
            int tmp = (end - start + 1) - max;
            if (tmp <= k)
            {
                if(ans < (end - start + 1))
                    ans = end - start + 1;
            }
            else{
                // need to shrink because the tmp is greater than k
                map[s.charAt(start) - 'A']--;
                map[s.charAt(end) - 'A']--; // simulate because the loop will add it at the beginning
                start++;
                continue;
            }
            end++;
            
        }
        return ans;
        
    }
}
