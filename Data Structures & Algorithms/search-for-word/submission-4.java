class Solution {
    public boolean exist(char[][] board, String word) {
        // 17/11, What if I can't be dangerously successful...
        // Scary but I'm gonna make that shit, no matter how hard it is, my journey will be extraordinary
        // ---------------------------------------------
        // Intuition: I'm gonna traverse all elements in the board. Once I encounter the first character of the word, I start to use deep first search to find solution. If I reach the (n-1, n-1) cell and still can't find the word, it will result in false.
        // Notes: we can't use a cell twice, need to think a way to prevent dfs from using old cells -> use a hashset
        int m = board.length; // number of rows
        int n = board[0].length; // number of cols
        int len = word.length();
        int dirX[] = {0, 1, 0, -1};
        int dirY[] = {-1, 0, 1, 0};
        Set<Integer> set = new HashSet<>();
        // traverse
        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                if (board[i][j] == word.charAt(0))
                {
                    if (backtracking(board, m, n, i, j, word, len, 0, dirX, dirY, set))
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtracking(char[][] board, int m, int n, int i, int j, String word, int len, int index, int[]dirX, int[]dirY, Set<Integer> set)
    {
        if (index == len) // we iterated the whole word, so word is found
        {
            return true;
        }
        boolean isNextValid = false;
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (board[i][j] == word.charAt(index))
        {   
            if (set.contains(n * i + j)) return false;
            set.add(n * i + j);
            for (int k = 0; k < 4; ++k)
            {
                isNextValid = isNextValid || backtracking(board, m, n, i + dirX[k], j + dirY[k], word, len, index + 1, dirX, dirY, set);
            }
            set.remove(n * i + j);
        }
        return isNextValid;
    }
}
