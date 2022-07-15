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

    int result;

    private void sumRoots(TreeNode curr, int temp) {
        if (curr == null) {
            return;
        }
        if (curr.left == null && curr.right == null) {
            result+=(temp*10+curr.val);
            return;
        }
        sumRoots(curr.left, result, temp*10+curr.val);
        sumRoots(curr.right, result, temp*10+curr.val);
    }

    public int sumNumbers(TreeNode root) {
        sumRoots(root, 0);
        return result;
    }
}