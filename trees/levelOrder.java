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

    private void addNodes(TreeNode curr, int layer, List<List<Integer>> result) {
        if (curr == null) {
            return;
        }
        if (result.size() < layer) {
            result.add(new ArrayList());
        }
        List<Integer> toAdd = result.get(layer-1);
        toAdd.add(curr.val);
        addNodes(curr.left, layer+1, result);
        addNodes(curr.right, layer+1, result);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        addNodes(root, 1, result);
        return result;
    }
}