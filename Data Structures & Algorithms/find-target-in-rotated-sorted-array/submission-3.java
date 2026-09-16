class Solution {
    public int search(int[] nums, int target) {
        // Today is 16 Sep, waiting for love...
        // Approach is the same as finding the minimum value in this rotated sorted array. 
        // With x is the answer, applying binary search. We have 2 ascending array, sort1 and sort2 respectively. All numbers in sort1 > all numbers in sort2.
        // If mid in sort1, mid > start. Else, mid < start.
        int ans = -1;
        int start = 0, end = nums.length - 1;
        while (start <= end)
        {
            int mid = (start + end) / 2;
            System.out.println(mid);
            if (nums[mid] == target)
                return mid;
            if (nums[mid] >= nums[0]) // mid in sort1
            {
                if (nums[mid] < target) // target in the right hand of mid in sort1
                    start = mid + 1;
                else
                {
                    if (target >= nums[0])
                        end = mid - 1;
                    else
                        start = mid + 1;
                }
            }
            else{ // mid in sort2
                if (nums[mid] > target) // target in the left hand of mid in sort2
                    end = mid - 1;
                else{
                    if (target >= nums[0])
                        end = mid - 1;
                    else
                        start = mid + 1;
                }
            }
        }
        return ans;
    }
}
