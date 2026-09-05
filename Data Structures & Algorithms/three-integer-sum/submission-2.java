class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i)
        {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int start = i + 1, end = nums.length - 1;
            while (start < end)
            {
                if (nums[start] + nums[i] + nums[end] == 0)
                {
                    List<Integer> candidate = Arrays.asList(nums[start], nums[i], nums[end]);
                    ans.add(candidate);
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start - 1])
                    start++;
                }
                else if (nums[start] + nums[i] + nums[end] > 0)
                    end--;
                else start++;
            }
        }
        return ans;
    }
}
