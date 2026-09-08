class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        int ans = 0;
        int n = tokens.length;
        for (int i = 0; i < n; ++i)
        {
            if (isNumber(tokens[i]))
                stack.push(tokens[i]);
            else{
                int number2 = Integer.parseInt(stack.pop());
                int number1 = Integer.parseInt(stack.pop());
                int value = 0;
                switch(tokens[i]){
                    case("+"):
                        value = number1 + number2;
                        break;
                    case("-"):
                        value = number1 - number2;
                        break;
                    case("*"):
                        value = number1 * number2;
                        break;
                    case("/"):
                        value = number1 / number2;
                        break;
                }
                stack.push(Integer.toString(value));
            }
        }
        return Integer.parseInt(stack.peek());
    }
    public boolean isNumber(String x)
    {
        return x.matches("-?\\d+");
    }

}
