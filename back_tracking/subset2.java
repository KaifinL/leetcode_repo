class Solution {
    private void addSubset(List<List<Integer>> result, List<Integer> temp, int index, int []nums) {
        result.add(new ArrayList(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            addSubset(result, temp, i+1, nums);
            temp.remove(temp.size()-1);
            while (i < nums.length-1 && nums[i]==nums[i+1])
            i++;
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        addSubset(result, new ArrayList(), 0, nums);
        return result;
    }
}