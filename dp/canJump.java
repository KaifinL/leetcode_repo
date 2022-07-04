class Solution {
    public boolean canJump(int[] nums) {
        boolean[] cj = new boolean[nums.length];
        cj[nums.length-1] = true;
        for (int i = nums.length-2; i>= 0; i--) {
            boolean any = false;
            for (int j = Math.min(i+nums[i], nums.length-1); j> 0;j--) {
                if (cj[j]) {
                    any = true;
                    break;
                }
            }
            if (any) {
                cj[i] = true;
            } else {
                cj[i] = false;
            }
        }
        return cj[0];
    }
}