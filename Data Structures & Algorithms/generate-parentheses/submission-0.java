class Solution {
    public List<String> generateParenthesis(int n) {
        // 15/11, how long have I liked her ?
        // Approach: Well-formed parentheses are open-close brackets in a correct order. Technically, this pattern requires stack structure. How to apply stack and backtracking in this challenge ?
        // Just 1 rule -> Always use a close bracket after using one open bracket. 
        // We can generate all possible cases and check whether that case is valid, but it will be a waste of time, there must be a better solution.
        // CRITICAL: openN and closeN can solve the problem, stack is crazily redundant. Let's me show
        List<String> ans = new ArrayList<>();
        StringBuilder element = new StringBuilder();
        backtracking(ans, element, n, n, n);
        return ans;
    }
    private void backtracking(List<String> ans, StringBuilder element, int openN, int closeN, int n)
    {
        if (openN == 0 && closeN == 0)
        {
            System.out.println(element.toString());
            ans.add(element.toString());
            return;
        }
        if (openN > 0)
        {
            element.append("(");
            backtracking(ans, element, openN - 1, closeN, n);
            element.deleteCharAt(element.length() - 1);
        }
        if (closeN > 0 && closeN > openN)
        {
            element.append(")");
            backtracking(ans, element, openN, closeN - 1, n);
            element.deleteCharAt(element.length() - 1);
        }
    }
}
