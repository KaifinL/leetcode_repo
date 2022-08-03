class Solution {
    public int maximalSquare(char[][] matrix) {
        int ms[][] = new int[matrix.length+1][matrix[0].length+1];
        int maximum = 0;
        for (int i = matrix.length; i >= 0; i--) {
            for (int j = matrix[0].length; j>=0; j--) {
                if (i == matrix.length || j == matrix[0].length) {
                    ms[i][j] = 0;
                } else if (matrix[i][j] == '1') {
                    ms[i][j] = Math.min(Math.min(ms[i][j+1], ms[i+1][j]), ms[i+1][j+1])+1;
                } else {
                    ms[i][j] = 0;
                }
                maximum = Math.max(maximum, ms[i][j]);
            }
        }
        return maximum*maximum;
    }
}


/*
optimized solution : use 1-dimension array

from official solution area...

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }
}

*/