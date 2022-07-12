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
    int hight;

    private void addNodes(LinkedHashMap result, int layer, TreeNode root) {
        if (root == null) {
            this.hight = Math.max(hight, layer-1);
            return;
        }
        if (result.get(layer)==null) {
            result.put(layer, root.val);
        }
        addNodes(result, layer+1, root.right);
        addNodes(result, layer+1, root.left);
    }


    public List<Integer> rightSideView(TreeNode root) {
        if (root==null) {
            return new ArrayList();
        }
        this.hight = 0;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap();
        
        addNodes(map, 0, root);
        List<Integer> result = new ArrayList();
        for (int i = 0; i <= hight; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}