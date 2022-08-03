class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int begin = nums.length - k;
        int []result = new int[nums.length];
        System.arraycopy(nums, begin, result, 0, k);
        System.arraycopy(nums, 0, result, k, nums.length-k);
        System.arraycopy(result, 0, nums, 0, nums.length);
    }
}


/*

solution from discussion area, which uses constant space! 
The idea is easy, but actually hard to think.. I didn't figure this out
at the first time.. So do reviews!

public class Solution {

    public void rotate(int[] nums, int k) {

        if(nums == null || nums.length < 2){
            return;
        }
        
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        
    }

    private void reverse(int[] nums, int i, int j){
        int tmp = 0;       
        while(i < j){
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}

*/