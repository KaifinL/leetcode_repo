class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        subs(result, new ArrayList(), 0, nums);
        return result;
    }


    private void subs(List<List<Integer>> result, List<Integer> temp, 
            int begin, int []nums) {
        result.add(new ArrayList(temp));
        for (int i = begin; i < nums.length; i++) {
            temp.add(nums[i]);
            subs(result, temp, i+1, nums);
            temp.remove(temp.size()-1);
        }
    }
}