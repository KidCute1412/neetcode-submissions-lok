class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        if (n % 2 != 0) return false;
        // Aproach: If open bracket, add to stack. if close bracket, check it with peek of stack and remove if valid. True when stack is finally empty.
        for(int i = 0; i < n; ++i)
        {
            if (isOpenBracket(s.charAt(i)))
                stack.push(s.charAt(i));
            else{
                
                if(!stack.isEmpty() && isValidBracketPair(stack.peek(), s.charAt(i)))
                {
                    stack.pop();
                }
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
    public boolean isOpenBracket(char x)
    {
        return x == '(' || x == '[' || x == '{';
    }
    public boolean isValidBracketPair(char x, char y)
    {
        switch(x){
            case('('):
                return y == ')';
            case('{'):
                return y == '}';
            case('['):
                return y == ']';
        }
        return false;
    }
}
