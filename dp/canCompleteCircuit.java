class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int prev = 0, curr = 0, result = -1;
        for (int i = 0; i < gas.length; i++) {
            int profit = gas[i]-cost[i];
            prev += profit;
            if (curr + profit < 0) {
                curr = 0;
                result = -1;
            } else {
                curr += profit;
                if (result == -1) {
                    result = i;
                }
            }
        }
        if (result == -1 || prev < 0) {
            return -1;
        }
        return result;
    }
}