class Solution {

    private void reverse(int []nums, int l, int r) {
        while (l<r) {
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            r--;
            l++;
        }
    }

    public void nextPermutation(int[] nums) {
        // find the pivot
        int pivot = -1;
        for (int i = nums.length-1; i>0; i--) {
            if (nums[i]>nums[i-1]) {
                pivot = i-1;
                break;
            }
        }
        if (pivot == -1) {
            Arrays.sort(nums);
            return;
        }
        for (int i = nums.length-1; i>pivot; i--) {
            if (nums[i]>nums[pivot]) {
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }

        reverse(nums, pivot+1, nums.length-1);
    }
}