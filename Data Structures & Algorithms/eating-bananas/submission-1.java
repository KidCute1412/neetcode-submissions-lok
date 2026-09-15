class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int k = 0;
        // find the largest number of bananas in 1 pile.
        int max = 0;
        for (int i = 0; i < n; ++i)
        {
            if (max < piles[i])
                max = piles[i];
        }
        // We need to traverse k from 1 to max to check whether k is valid, the target is to find the smallest valid k value. And I'm gonna apply Binary Search to traverse from 1 to max
        int start = 1, end = max;
        int ans = 0;
        while (start <= end)
        {
            int mid = (start + end) / 2;
            int tmp = 0;
            for (int i = 0; i < n; ++i)
            {
                tmp += (int)Math.ceil((double)piles[i] / mid);
            }
            // This is valid, we just need to check if we can eat slower
            if (tmp <= h)
            {
                ans = mid;
                end = mid - 1;
            }
            // this means we need to eat faster
            else if (tmp > h)
            {
                start = mid + 1;
            }
        }
        return ans;
    }
}
