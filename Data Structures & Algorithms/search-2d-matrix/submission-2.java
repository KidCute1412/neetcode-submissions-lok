class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 14/9, wait f da rep...
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0, end = m * n - 1;
        System.out.println(start);
        System.out.println(end);
        while (start <= end)
        {
            int mid = (start + end) / 2;
            if (matrix[mid / n][mid % n] == target)
                return true;
            else if (matrix[mid / n][mid % n] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}
