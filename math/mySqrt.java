class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1;
        int right = x/2;
        while (left < right) {
            int mid = (left+right)/2;
            long product = (long) mid *mid;
            long plus_product = (long) (mid + 1) *(mid+1);
            if (product <= (long)x && plus_product >(long)x) {
                return mid;
            } else if (product < (long)x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}