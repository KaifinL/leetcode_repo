class Solution {


    // given the array nums, find all the possible permutations from 
    // nums[i] to nums[j] and append these arrays to temp accordingly.
    private void permute_helper(List<List<Integer>> result, List<Integer> temp, int[]nums, boolean []used) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            temp.add(nums[i]);
            used[i] = true;
            permute_helper(result, temp, nums, used);
            temp.remove(temp.size()-1);
            used[i] = false;
            int j = i+1;
            while (j < nums.length && nums[i]==nums[j]) {
                i++;
                j++;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        boolean used[] = new boolean[nums.length];
        permute_helper(result, new ArrayList(), nums, used);
        return result;
    }
}