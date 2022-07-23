class Solution {


    // this one comes from the discussion area. passed the test
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    // written by myself, dp solution. Failed tests... Time exceeds.
    public int trailingZeroes(int n) {
        long []non_zeors = new long[n+1];
        int []zeros = new int[n+1];
        non_zeors[0] = 1;
        zeros[0] = 0;
        for (int i = 1; i <= n; i++) {
            long curr = i * non_zeors[i-1];
            int nums_zeros = 0;
            while (curr % 10 == 0) {
                nums_zeros++;
                curr/=10;
            }
            non_zeors[i] = curr;
            zeros[i] = zeros[i-1] + nums_zeros;
        }
        return zeros[n];
    }
}