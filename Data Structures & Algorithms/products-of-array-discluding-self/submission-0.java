class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n ==0) return null;
        int ans[] = new int[n];
        int totalProduct = 1;
        int numZero = 0;
        for (int i = 0; i < n; ++i)
        {
            if (nums[i] != 0)
                totalProduct *= nums[i];
            else{
                numZero++;
            }
        }
        if (numZero > 1)
            return ans;
        for (int i = 0; i < n; ++i)
        {
            if (nums[i] == 0)
                ans[i] = totalProduct;
            else{
                if (numZero > 0)
                    ans[i] = 0;
                else{
                    ans[i] = totalProduct / nums[i];
                }
            }
        } 
        return ans;   
    }
}  
