class Solution {
    public boolean isUgly(int n) {
        if (n % 4 == 0) {
            return false;
        }
        for (int i = 6; i <= n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}