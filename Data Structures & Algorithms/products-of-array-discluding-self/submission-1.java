class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n == 0) return null;
        int prefixArr[] = new int[n];
        int suffixArr[] = new int[n];
        int ans[] = new int[n];
        for (int i = 0; i < n; ++i)
        {
            if (i == 0)
                prefixArr[i] = 1;
            else{
                prefixArr[i] = prefixArr[i - 1] * nums[i - 1];
            }
        }
        for (int i = n - 1; i >= 0; --i)
        {
            if (i == n - 1)
                suffixArr[i] = 1;
            else{
                suffixArr[i] = suffixArr[i + 1] * nums[i + 1];
            }
        }
        for (int i = 0; i < n; ++i)
        {
            ans[i] = prefixArr[i] * suffixArr[i];
        }
        return ans;
    }
}  
