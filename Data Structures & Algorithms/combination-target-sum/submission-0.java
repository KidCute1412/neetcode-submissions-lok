class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // 1/11 The beginning of the new month
        // Hope things be good to me and all of my precious ones
        // Journal: I think that I must be more active to everything in my life, about career, relationship, skills, English, characteristics. 
        // With her, I should be more and more active, tryna meet her and have real conversation instead of texting through messenger.
        // I know I'm feeling shy because of my fat body, not clean face skin and don't have a talent at making jokes. But, anyway this is my only life, I'm 21 and I will never be at this age anymore. Am I going to waste time being embarrassed all the time and missing all the oppoturnities that never come back again ?
        // Anyway, this is the earliest chance in my life - now. Yass, it's now, no time else.
        // Come on, I know I can do it, I can make things happen, be dangerously confident !
        // -------------------------------------
        // Start the first neetcode question of November
        // I think we can try all the possible combinations. When we touch element x, then we can choose all n elements in the next step as long as the current sum is smaller than target. If the current sum is exceeded the target number, we backtrack.
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        List<Integer> combination = new ArrayList<>();
        backtracking(res, combination, nums, n, target, 0, 0);
        return res;
    }
    private void backtracking(List<List<Integer>> res, List<Integer> combination, int[] nums, int n, int target, int i, int sum)
    {
        if (sum == target)
        {
            res.add(new ArrayList<>(combination));
            return;
        }
        if (sum > target || i == n)
        {
            return;
        }
        for (int j = i; j < n; ++j)
        {
            combination.add(nums[j]);
            backtracking(res, combination, nums, n, target, j, sum + nums[j]);
            combination.remove(combination.size() - 1);
        }
    }
}
