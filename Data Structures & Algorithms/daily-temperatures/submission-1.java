class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Love DA
        // Approach: Use a stack, if the next elements <= peek, then we add that index to stack, if the next element > peek, we store result and pop that peek. Like [2, 1, 1, 3], when we reach 3, we pop it and update [2, 1, 1] in turn.
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
            // considered element <= peek, so we didn't find the higher one
            while(i < n && !stack.isEmpty() && temperatures[i] <= temperatures[stack.peek()])
            {
                stack.push(i);
                ++i;
            }
            // considered element > peek, so we find the higher one and start to update the whole remaining elements in the stack
            while(i < n && !stack.isEmpty() && temperatures[i] > temperatures[stack.peek()])
            {
                ans[stack.peek()] = i - stack.peek();
                stack.pop(); 
            }
        }
        return ans;
    }
}
