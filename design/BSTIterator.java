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
class BSTIterator {

    List<Integer> vals;
    Interator<Integer> iter;

    private void addVals(TreeNode root) {
        if (root == null) {
            return;
        }
        addVals(root.left);
        vals.add(root.val);
        addVals(root.right);
    }

    public BSTIterator(TreeNode root) {
        this.vals = new ArrayList();
        addVals(root);
        this.iter = this.vals.iterator();
    }
    
    public int next() {
        return this.iter.next();
    }
    
    public boolean hasNext() {
        return this.iter.hasNext();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */