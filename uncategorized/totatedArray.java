class Solution {
    // return -1 if there is no such piviot.
    // return -2 if all equals.
    private int find_piviot(int []nums) {
        int left = 0;
        int right = nums.length -1;
        while (nums[left]==nums[right] && left<right) {
            left++;
        }
        if (left == right) {
            return -2;
        }
        if (nums[left] < nums[0]) {
            return left;
        }
        int standard = nums[left];
        while (left < right) {
            int mid = (left+right)/2;
            if (mid == 0) {
                return nums[1]<nums[0]?1:-1;
            }
            if (nums[mid]<nums[mid-1]) {
                return mid;
            }
            if (nums[mid] < standard) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        if (left == 0) {
            return -1;
        }
        return nums[left] < nums[left-1]? left:-1;
    }

    public boolean binary_search(int []nums, int target, int left, int right) {
        while (left < right) {
            int mid = (left+right)/2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target;
    }

    public boolean search(int[] nums, int target) {
        int piviot = find_piviot(nums);
        if (piviot == -1) {
            return binary_search(nums, target, 0, nums.length-1);
        } else if (piviot == -2) {
            return nums[0]==target;
        } else if (nums[0] <= target) {
            return binary_search(nums, target, 0, piviot);
        } else {
            return binary_search(nums, target, piviot, nums.length-1);
        }
    }
}