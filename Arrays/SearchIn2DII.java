class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0;        // start at first row
        int j = cols - 1; // start at last column

        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--; // move left
            } else {
                i++; // move down
            }
        }

        return false;
    }
}
