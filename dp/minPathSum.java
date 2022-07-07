class Solution {
    public int minPathSum(int[][] grid) {
        int [][]mps = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j==0) {
                    mps[i][j] = grid[i][j];
                } else if (i == 0) {
                    mps[i][j] = mps[i][j-1] + grid[i][j];
                } else if (j==0) {
                    mps[i][j] = mps[i-1][j] + grid[i][j];
                } else {
                    mps[i][j] = Math.min(mps[i][j-1], mps[i-1][j]) + grid[i][j];
                }
            }
        }
        return mps[grid.length-1][grid[0].length-1];
    }
}