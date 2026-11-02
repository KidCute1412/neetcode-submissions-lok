class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 2/11
        // Grinding Neetcode to keep streak :)))
        // Ye both streak Neetcode and Github commit
        // -----------------------------------
        // Intuition: The difference of this problem compared to the previous one is that candidates array can contain duplicate numbers.
        // Approach: just backtrack but the next recursion, try to call the next index instead of current index because one index can only be chosen once. 
        // CRITICAL MISTAKES: I thought that I don't need to care about duplicates because I keep choosing the next indexes throughout recursion. But it's wrong, when the tree start with the second number in a duplicate couple, the same combination can be formed again and we need to think about a way to identify and remove it.

        List<List<Integer>> res = new ArrayList<>();
        int n = candidates.length;
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(res, combination, candidates, n, target, -1, 0);
        return res;
    }
    private void backtracking(List<List<Integer>> res, List<Integer> combination, int[] candidates, int n, int target, int i, int sum)
    {
        if (sum == target)
        {
            res.add(new ArrayList<>(combination));
            return;
        }
        if (i == n || sum > target)
        {
            return;
        }
        for (int j = i + 1; j < n; ++j)
        {
            
            //if (j > 0 && candidates[j] == candidates[j - 1] && combination.size() == 0) continue;
            combination.add(candidates[j]);
            backtracking(res, combination, candidates, n, target, j, sum + candidates[j]);
            // The list is sorted, such as 1 2 5 5 5 8 9. I think in all 5 here, if we are moving forward, we can pick the 5 no matter what, but when we backtrack, we must skip the algorithm if it want to pick 5 again. Like pick 1 2 5, then backtrack, we pop 5, then we are not gonna pick 5 in the next index again
            while (j < n - 1 && candidates[j + 1] == combination.get(combination.size() - 1))
            {
                j++;
            }
            combination.remove(combination.size() - 1);
            
            
        }
    }
}
