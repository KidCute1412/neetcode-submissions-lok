class Solution {
    public int findMin(int[] nums) {
        // ngl: i like DA so much, ye and it's a little sad that she doesn't response to me, like she doesn't care about me...
        int n = nums.length;
        int ans = Math.min(nums[0], nums[n - 1]); // case these are edge cases, we don't compare them to their right and left side
        // Intuition: Rotate means the last elements rotate to the first element. So the smallest one, if it is located in the middle of the array, its value is smaller than its left and smaller than its right. 
        // Using binary search. If we hit a value that > left and < right, it's in upward trend. With x is the answer, all elements in the left hand of x must be greater than all elements in the right hand of x. Based on this, we know when to move start or end pointer.
        int start = 0, end = n - 1;
        while (start <= end)
        {
            int mid = (start + end) / 2;
            if (mid > 0 && mid < n - 1 && nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1])
            {
                ans = nums[mid];
                break;
            }
            // mid on x left, move start
            if (nums[mid] > nums[end])
            {
                start = mid + 1;
            }
            // mid on x right, move end
            else{
                end = mid - 1;
            }
        }
        return ans;

    }
}
