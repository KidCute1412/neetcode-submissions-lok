class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Approach 2: HashSet
        // Create 3 hashset including one to check rows, one to check cols and one to check 3x3 boxes.
        // Traverse each cell, if any value has been already existed in any set, it is invalid.
        // Notes: Technically, they are 3 maps that their values are hashset type
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<String, Set<Character>> boxMap = new HashMap<>();
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; ++i)
        {
            for (int j = 0; j < cols; ++j)
            {
                if (board[i][j] == '.')
                    continue;
                // row map
                if (!rowMap.containsKey(i))
                {
                    rowMap.put(i, new HashSet<>());
                }
                // col map
                if (!colMap.containsKey(j))
                {
                    colMap.put(j, new HashSet<>());
                }
                // 3x3 boxes map
                String x = Integer.toString(i / 3) + "," + Integer.toString(j / 3);
                if (!boxMap.containsKey(x))
                {
                    boxMap.put(x, new HashSet<>());
                }
                // Check existence
                if (rowMap.get(i).contains(board[i][j]) ||
                    colMap.get(j).contains(board[i][j]) ||
                    boxMap.get(x).contains(board[i][j]))
                {
                    return false;
                }
                rowMap.get(i).add(board[i][j]);
                colMap.get(j).add(board[i][j]);
                boxMap.get(x).add(board[i][j]);
            }

        }
        return true;
    }
}
