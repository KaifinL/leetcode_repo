class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left+right)/2;
            if (mid == 0) {
                return (nums[0] > nums[1])?0:1;
            }
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            } else if (nums[mid] > nums[mid-1]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}