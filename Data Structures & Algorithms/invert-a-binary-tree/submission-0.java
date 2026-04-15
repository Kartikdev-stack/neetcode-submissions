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
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            // Base Condition
            return root;
        }

        TreeNode left=invertTree(root.left); // record the left value
        TreeNode right=invertTree(root.right); // record the right value

        root.left=right;
        root.right=left;

        return root;
    }
}
