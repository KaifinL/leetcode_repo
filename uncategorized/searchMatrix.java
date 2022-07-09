class Solution {
    //return -1 if not exist.
    private int find_row(int [][]matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        int mid = (left+right)/2;
        while (left < right && mid < matrix.length-1) {
            if (target >= matrix[mid][0] && target < matrix[mid+1][0]) {
                return mid;
            } else if (target < matrix[mid][0]) {
                right = mid;
            } else {
                left = mid+1;
            }
            mid = (left+right)/2;
        }
        if (left == 0) {
            return (target>=matrix[0][0]) ? 0:-1;
        } else if (mid == matrix.length-1) {
            return target>=matrix[matrix.length-1][0]?matrix.length-1:-1;
        } else {
            return -1;
        }
    }

    private boolean search_target(int []row, int target) {
        if (row.length < 10) {
            for (int i = 0; i < row.length; i++) {
                if (row[i]==target) {
                    return true;
                } else if (row[i] > target) {
                    return false;
                }
            }
        }

        int left = 0;
        int right = row.length-1;
        while (left < right) {
            int mid = (left+right)/2;
            if (target == row[mid]) {
                return true;
            } else if (target < row[mid]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return row[left]==target;
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int row = find_row(matrix, target);
        if (row == -1) {
            return false;
        }
        return search_target(matrix[row], target);
    }
}