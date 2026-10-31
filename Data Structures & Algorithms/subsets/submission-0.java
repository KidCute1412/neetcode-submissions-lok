class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // 31/10 I'm back in the end of October
        // I'm really missing her and I hope that she knows I want to be with her, not just a normal friend...
        // Get started...
        // Approach: Obviously, this problem is familiar to me, it's just a normal backtracking assignment
        // Maybe a little breakpoint at unique subsets
        // The key is that we keep iterating the next index instead of repeating every indexes in the array, so it makes sure the next branch of the tree won't include old values -> preventing duplicate values.
        // Notes: a CRITICAL MISTAKE that I did is that I add set directly to result list while modifying that 'set' throughout backtracking process. UNEXPECTEDLY, all elements in 'result' are the same because they are all pointed to 'set' location. ---> SOLUTION: always create a snapshot of set when we need to add it to res, not set directly. 
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        backtrack(result, set, nums, 0, n);
        return result;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> set, int[] nums, int i, int n)
    {
        if (i == n) // End condition
        {
            res.add(new ArrayList<>(set)); // THIS is CRITICAL
            return;
        }
        for (int j = 0; j < 2; ++j)
        {
            if (j == 0) // skip current element
            {
                backtrack(res, set, nums, i + 1, n);
            }
            else{
                // add current element
                set.add(nums[i]);
                backtrack(res, set, nums, i + 1, n);
                set.remove(set.size() - 1);
            }
        }
    }
}
