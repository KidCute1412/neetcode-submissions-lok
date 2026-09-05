class Solution {
    public boolean isValidSudoku(char[][] board) {
        int checkArr[] = new int[10];
        int rows = board.length;
        int cols = board[0].length;
        // check row
        for (int i = 0; i < rows; ++i)
        {
            for (int j = 0; j < cols; ++j)
            {
                if (board[i][j] == '.') continue;
                checkArr[board[i][j] - '0']++;
                if (checkArr[board[i][j] - '0'] > 1) return false;
            }
            for (int k = 0; k < 10; ++k)
            {
                checkArr[k] = 0;
            }
        }
        // check col
        for (int j = 0; j < cols; ++j)
        {
            for (int i = 0; i < rows; ++i)
            {
                if (board[i][j] == '.') continue;
                checkArr[board[i][j] - '0']++;
                if (checkArr[board[i][j] - '0'] > 1) return false;
            }
            for (int k = 0; k < 10; ++k)
            {
                checkArr[k] = 0;
            }
        }
        // check subtable
        int rangeRow = 3;
        while (rangeRow <= 9)
        {
            
            for (int rangeCol = 3; rangeCol <= 9; rangeCol+=3)
            {
                for (int i = rangeRow - 3; i < rangeRow; ++i)
                {
                    for (int j = rangeCol - 3; j < rangeCol; ++j)
                    {
                        if (board[i][j] == '.') continue;
                        checkArr[board[i][j] - '0']++;
                        if (checkArr[board[i][j] - '0'] > 1) return false;
                    }
                }
                for (int k = 0; k < 10; ++k)
                {
                    checkArr[k] = 0;
                }
            }
            rangeRow += 3;
        }
        return true;
        
    }
}
