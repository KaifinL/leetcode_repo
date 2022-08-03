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


    private void addVals(List<List<Integer>> result, int layer, TreeNode curr) {
        if (curr == null) {
            return;
        }
        if (layer >= result.size()) {
            result.add(new ArrayList());
        }
        List<Integer> curr = result.get(layer);
        curr.add(curr.val);
        addVals(result, layer+1, curr.left);
        addVals(result, layer+1, curr.right);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        addVals(result, 0, root);
        for (int i = 1; i < result.size(); i+=2) {
            Collectoins.reverse(result.get(i));
        }
        return result;
    }
}