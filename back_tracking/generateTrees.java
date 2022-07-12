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

    private void 

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
    private List<TreeNode> generateTrees(int end, int begin) {
        if (begin > end) {
            return new ArrayList<TreeNode>();
        } else if (begin == end) {
            List<TreeNode> result = new ArrayList<TreeNode>();
            result.add(new TreeNode(begin));
            return result;
        }
        List<TreeNode> result = new ArrayList<TreeNode>();
        for (int i = begin; i<=end; i++) {
            
            if (i == begin) {
                List<TreeNode> right = generateTrees(end, begin+1);
                for (TreeNode r_child : right) {
                    TreeNode curr = new TreeNode(i);
                    curr.right = r_child;
                    result.add(curr);
                }
            } else if (i==end) {
                List<TreeNode> left = generateTrees(end-1, begin);
                for (TreeNode r_child : left) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = r_child;
                    result.add(curr);
                }
            } else {
                List<TreeNode> left = generateTrees(i-1, begin);
                List<TreeNode> right = generateTrees(end, i+1);
                for (TreeNode l_child:left) {
                    for (TreeNode r_child:right) {
                        TreeNode curr = new TreeNode(i);
                        curr.left = l_child;
                        curr.right = r_child;
                        result.add(curr);
                    }
                }
            }

        }
        return result;
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(n, 1);
    }
}
}