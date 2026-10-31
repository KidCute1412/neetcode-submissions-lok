class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Approach 2: This is bit-manipulation.
        // The idea is that each subset can be represent in a form of a bit set (001, 010, 100) with 1 means nums[that index] is chosen, 0 is excluded.
        // For ex, with nums array includes 3 elements, it means there will be 2^3 = 8 subsets. Instead of using 2 ^ n, we can use 1 << n because 1 << n equals to 2 ^ n.
        // Notes: my code is implemented in java and the constraint makes sure n <= 10, so 1 << n = 2^n. If n reaches to 32, things will be wrong because java only shifts 5 right operand bits for integer type. 
        // With python, 1 << n = 2^n in almost cases.
        // So, this is an approach that I can consider, backtracking is still better for all languages.
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < (1 << n); ++i) // iterate 2^n cases
        {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; ++j)
            {
                if ((i & (1 << j)) != 0) // 1 << j is a trick, we can think of only i && j but 1 << j will make sure there is at least one bit 1 in j, because if j = 0, it won't have bit 1 and this condition will be surely invalid
                {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}
