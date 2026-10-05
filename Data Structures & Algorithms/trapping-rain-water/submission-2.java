class Solution {
    public int trap(int[] height) {
        // Intuition:
        // Wrong approach: I tried to use 2 pointers to track the first peak and the second peak contains a hole, but it's hard to confirm its a peak or jus a hill.
        // Correct approach: Try to calculate the amount of water that can be trapped in a cell, not an area. With a is the peak in the left, b is the peak in the right, that amount of water is min(a, b) - height[i].
        // --> Use 2 array to store prefix max and suffix max peak.
        int n = height.length;
        int[] prefixPeak = new int[n];
        int[] suffixPeak = new int[n];
        int max = 0;
        // Identify prefixPeak
        for (int i = 0; i < n; ++i)
        {
            if(height[i] > max)
                max = height[i];
            prefixPeak[i] = max;
        }
        max = 0;
        // Identify suffixPeak
        for (int i = n - 1; i >= 0; --i)
        {
            if(height[i] > max)
                max = height[i];
            suffixPeak[i] = max;
        }
        int totalArea = 0;
        for(int i = 0; i < n; ++i)
        {
            int tmp = Integer.min(prefixPeak[i], suffixPeak[i]) - height[i];
            totalArea += tmp;
        }
        return totalArea;

    }
}
