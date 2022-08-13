class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> num_index = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (num_index.getOrDefault(nums[i], -1) == -1) {
                num_index.put(nums[i], i);
            } else {
                int index = num_index.get(nums[i]);
                if (i - index <= k) {
                    return true;
                } else {
                    num_index.put(nums[i], i);
                }
            }
        }
        return false;
    }
}