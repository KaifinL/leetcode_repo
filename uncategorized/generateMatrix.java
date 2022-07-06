class Solution {
    public int[][] generateMatrix(int n) {
        int [][]result = new int[n][n];
        int i = 0, j = 0, counter = 1;
        char dir = 'r';
        while (n <= counter) {
            result[i][j] = counter;
            if (dir == 'r' && (j == n-1 || result[i][j+1]!=0)) {
                dir = 'd';
            } else if (dir == 'd' && (i==n-1 || result[i+1][j]!=0)) {
                dir = 'l';
            } else if (dir == 'l' && (i == 0 || result[i-1][j] != 0)) {
                dir = 'u';
            } else if (dir == 'u' && (j == 0 || result[i][j-1]!= 0)) {
                dir = 'r';
            }

            if (dir == 'r') {
                j++;
            } else if (dir == 'd') {
                i++;
            } else if (dir == 'l') {
                j--;
            } else if (dir == 'u') {
                i--;
            }

            n++;
        }
        return result;
    }
}