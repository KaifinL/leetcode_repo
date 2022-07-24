
//passed the tests but not fast enough...
class Solution {

    private boolean binary_search(int []row, int target) {
        int left = 0;
        int right = row.length-1;
        while (left < right) {
            int mid = (left+right)/2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return row[mid] == target;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target) {
                if (binary_search(matrix[i], target)) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}


// better solution from discussion area
// link:https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66140/My-concise-O(m%2Bn)-Java-solution
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}