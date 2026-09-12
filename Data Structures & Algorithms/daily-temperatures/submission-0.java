class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Love DA
        // Approach: 
        int n = temperatures.length;
        if (n == 0) return null;
        int ans[] = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        if (n == 1) return ans;
        stack.push(0);
        int i = 1;
        while(i < n)
        {
            if(stack.isEmpty())
            {
                stack.push(i);
                i++;
            }
            while(i < n && !stack.isEmpty() && temperatures[i] <= temperatures[stack.peek()])
            {
                stack.push(i);
                ++i;
            }
            while(i < n && !stack.isEmpty() && temperatures[i] > temperatures[stack.peek()])
            {
                ans[stack.peek()] = i - stack.peek();
                stack.pop(); 
            }
        }
        return ans;
    }
}
