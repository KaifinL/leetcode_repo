class Solution {
    public int[] productExceptSelf(int[] nums) {
        int lefts[] = new int[nums.length];
        int rights[] = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            lefts[i] = product;
            product *= nums[i];
        }
        product = 1;
        for (int i = nums.length-1; i>=0; i--) {
            rights[i] = product*lefts[i];
            product*=nums[i];
        }
        return rights;
    }
}