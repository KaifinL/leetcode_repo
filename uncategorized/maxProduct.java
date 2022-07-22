/*
A solution model from discussion section. This problem is also shown
in CS374's homework. Kinda tricky, will need to be reviewed sometimes.
The main idea is that a swap needs to be done when the current value is 
less than zero, so that the previous maximum become minimum.

*/


class Solution {
    public int maxProduct(int[] nums) {
        int maximum = nums[0];
        int curr_max = maximum, curr_min = maximum;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = curr_min;
                curr_min = curr_max;
                curr_max = temp;
            }
            curr_max = Math.max(nums[i], curr_max*nums[i]);
            curr_min = Math.min(nums[i], curr_min*nums[i]);
            maximum = Math.max(maximum, curr_max);
        }

        return maximum;
    }
}