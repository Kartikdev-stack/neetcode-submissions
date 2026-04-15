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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> values=new ArrayList<>();
        dfs(root, 0, values); // initializing depth first search
        return values;
    }

    public void dfs(TreeNode root, int level, List<Integer> values){

        if(root==null)
            return;

        if(level==values.size())
            values.add(root.val);
        
        dfs(root.right, level+1, values);
        dfs(root.left, level+1, values);
    }
}
