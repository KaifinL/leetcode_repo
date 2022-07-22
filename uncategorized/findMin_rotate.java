class Solution {
    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length-1]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = (left+right) / 2;
            if (mid == 0) {
                return Math.min(nums[left], nums[right]);
            }
            if (nums[mid] < nums[mid-1]) {
                return nums[mid];
            } else if (nums[mid] > nums[0]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}