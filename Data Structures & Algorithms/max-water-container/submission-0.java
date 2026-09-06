class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int start = 0, end = n - 1;
        int maxArea = 0;
        while (start < end)
        {
            int curArea = (end - start) * Integer.min(heights[start], heights[end]);
            if (curArea > maxArea)
                maxArea = curArea;
            if (heights[start] <= heights[end])
                start++;
            else
                end--;
        }
        return maxArea;
    }
}
