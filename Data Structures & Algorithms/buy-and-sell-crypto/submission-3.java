class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
        {
            return 0;
        }
        int n = prices.length;
        int min = prices[0];
        int ans = 0;
        for (int i = 0; i < n; ++i)
        {
            if (prices[i] < min)
                min = prices[i];
            ans = Integer.max(ans, prices[i] - min);
        }
        return ans;
        
    }
}
