class NumArray {
    //sums[i] represent the sum from range 0 to i;
    int []sums;
    int nums;

    public NumArray(int[] nums) {
        int counter = 0;
        this.nums = nums;
        this.sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            counter+=nums[i];
            this.sums[i] = counter;
        }
    }
    
    public void update(int index, int val) {
        int diff = this.nums[index]-val;
        for (int i = index; i < this.sums.length; i++) {
            this.sums[i] -= diff;
        }
        this.nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) {
            return this.sums[right];
        } else {
            return this.sums[right]-this.sums[left-1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */