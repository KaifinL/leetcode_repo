/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // construct a high-balanced binary search tree from nums[i] to nums[j]
    public TreeNode sort_helper(int []nums, int begin, int end) {
        int total_nums = end-begin;
        // there is one number we need to handle
        if (total_nums == 0) {
            return new TreeNode(nums[begin]);
        } // there are two nums left in the array.
        else if (total_nums == 1) {
            return new TreeNode(nums[end], new TreeNode(nums[begin]), null);
        } else {
            int mid = (begin+end)/2;
            TreeNode left = sort_helper(nums, begin, mid-1);
            TreeNode right = sort_helper(nums, mid+1, end);
            return new TreeNode(nums[mid], left, right);
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sort_helper(nums, 0, nums.length-1);
    }
}