class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i)
        {
            int start = i + 1, end = nums.length - 1;
            while (start < end)
            {
                if (nums[start] + nums[i] + nums[end] == 0)
                {
                    List<Integer> candidate = new ArrayList<>(List.of(nums[start], nums[i], nums[end]));
                    Collections.sort(candidate);
                    set.add(candidate);
                    start++;
                }
                else if (nums[start] + nums[i] + nums[end] > 0)
                    end--;
                else start++;
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}
