class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < Math.min(i+k+1, nums.length); j++) {
                long result = Math.abs((long)nums[i] - (long)nums[j]);
                if (result <= (long)t) {
                    return true;
                }
            }
        }
        return false;
    }
}