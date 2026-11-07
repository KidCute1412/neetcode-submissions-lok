class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // 7/11 Will I live a great life like Ronaldo ?
        //----------------------------------------------
        // Approach: Standard permutations, return all possible combinations -> return all branches
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        int n = nums.length;
        boolean[] selected = new boolean[n];
        for (int i = 0; i < n; ++i)
            selected[i] = false;
        backtracking(res, combination, nums, selected, n, 0);
        return res;
    }
    private void backtracking(List<List<Integer>> res, List<Integer> combination, int[] nums, boolean[] selected, int n, int count)
    {
        if (count == n) // all selected
        {
            res.add(new ArrayList(combination));
            return;
        }
        for (int j = 0; j < n; ++j)
        {
            if (selected[j]) continue;
            combination.add(nums[j]);
            selected[j] = true;
            backtracking(res, combination, nums, selected, n, count + 
            1);
            combination.remove(combination.size() - 1);
            selected[j] = false;
        }
    }
}
