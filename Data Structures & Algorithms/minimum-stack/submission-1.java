class MinStack {
    // Use an additional min stack to store the min value, so that we can find min value in O(1) time, but we need O(n) space
    private Deque<Integer> stack = null;
    private Deque<Integer> minStack = null;
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) minStack.push(val);
        else{
            int min = Integer.min(minStack.peek(), val);
            minStack.push(min);
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
