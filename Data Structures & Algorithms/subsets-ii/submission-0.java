class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 7/11 I solved 2 medium problems today. Grinding leetcode to sharpen my logical mindset
        // P/s: I don't want an ordinary life anymore, just fucking shoot to the star
        // -------------------------------------
        // Approach:
        // Standard subset contains no duplicates, this level-up question makes subset be able to contain duplicate subsets (CRITICAL, it says not duplicate subsets, it doesnot say not duplicate elements)
        // Notes: the given array may contain duplicates, and my solution must not contain duplicate subsets. (Tryna think an efficient way to remove duplicate without checking selected sets every times)
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(res, subset, nums, n, 0);
        return res;
    }
    private void backtracking(List<List<Integer>> res, List<Integer> set, int[] nums, int n, int i)
    {
        if (i == n)
        {
            res.add(new ArrayList<>(set));
            return;
        }
        set.add(nums[i]);
        // This means we pick i
        backtracking(res, set, nums, n, i + 1);
        // This is the magic part, because the array is sorted, so we won't pick the next element if it equals to the one we're gonna remove from the set, like [1,1,1], when we're gonna remove the second index, we won't want to pick the third index because all subsets created by [1,1] are already done
        while (i < n - 1 && nums[i + 1] == set.get(set.size() - 1))
            i++; 
        set.remove(set.size() - 1);
        // This means we don't pick i
        backtracking(res, set, nums, n, i + 1);
    }
}
