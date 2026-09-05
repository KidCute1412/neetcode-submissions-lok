class Solution {
    public int longestConsecutive(int[] nums) {
        // Approach: Use a hashset, then check a element exists but that element - 1 doesnot exist, so we can presume that element is the start of a sequence, try incrementing it to find the longest sequence
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i)
        {
            set.add(nums[i]);
        }
        int tmp = 0;
        int ans = 0;
        for (int i = 0; i < n; ++i)
        {
            if(!set.contains(nums[i] - 1))
            {
                int next = nums[i];
                while(set.contains(next))
                {
                    tmp++;
                    if(tmp > ans)
                        ans = tmp;
                    next++;
                }
            }
            tmp = 0;
        }
        return ans;
    }
}
