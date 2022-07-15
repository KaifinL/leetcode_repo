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
    private void traverse(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> temp) {
        if (root == null) {
            return;
        }
        if (targetSum == root.val && root.left == null && root.right == null) {
            temp.add(root.val);
            result.add(new ArrayList(temp));
            temp.remove(temp.size()-1);
            return;
        }
        temp.add(root.val);
        traverse(root.left, targetSum-root.val, result, temp);
        traverse(root.right, targetSum-root.val, result, temp);
        temp.remove(temp.size()-1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList();
        traverse(root, targetSum, result, new ArrayList());
        return result;
    }
}