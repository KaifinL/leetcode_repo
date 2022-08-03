import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        for (int curr = 0; curr < nums.length - 2; curr++) {
            int left = curr + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[curr] + nums[left] + nums[right] == 0) {
                    List<Integer> temp = new ArrayList();
                    temp.add(nums[curr]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    int j = left + 1;
                    while (j < right && nums[left] == nums[j]) {
                        left++;
                        j++;
                    }
                    left++;
                    j = right - 1;
                    while (j > left && nums[j] == nums[right]) {
                        right--;
                        j--;
                    }
                    right--;
                } else if (nums[curr] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
            int j = curr + 1;
            while (j < nums.length - 2 && nums[j] == nums[curr]) {
                j++;
                curr++;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Solution test = new Solution();
        test.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}