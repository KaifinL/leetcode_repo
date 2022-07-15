class Solution {
    public int maxProfit(int[] prices) {
        int [][]mpf = new int[prices.length+1][2];
        mpf[prices.length][0] = 0;
        mpf[prices.length][1] = 0;
        for (int i = prices.length-1; i>= 0; i--) {
            mpf[i][0] = Math.max(mpf[i+1][0], mpf[i+1][1]-prices[i]);
            mpf[i][1] = Math.max(mpf[i+1][1], mpf[i+1][0]+prices[i]);
        }
        return mpf[0][0];
    }
}