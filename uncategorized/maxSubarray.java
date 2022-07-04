class Solution {
    public int maxSubArray(int[] nums) {
        boolean all_negative = true;
        int temp = 0, maximum = 0, maximum_nagetive = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=0) {
                all_negative = false;
            } else {
                maximum_nagetive = Math.max(maximum_nagetive, nums[i]);
            }
            temp = Math.max(temp+nums[i], 0);
            maximum = Math.max(temp, maximum);
        }
        return all_negative? maximum_nagetive:maximum;
    }
}