class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n - 1;
        while(start <= end)
        {
            int pivot = (start + end) / 2;
            if (nums[pivot] == target )
                return pivot; 
            else if (nums[pivot] < target)
                start = pivot + 1;
            else{
                end = pivot - 1;
            }
        }
        return -1;
    }
}
