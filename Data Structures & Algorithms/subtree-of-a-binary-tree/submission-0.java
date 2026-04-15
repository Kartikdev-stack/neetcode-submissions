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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
         if(subRoot==null){ // if subRoot is null, its true as it is a subTree
            return true;
         }

         if(root==null){
            return false; // if root is null with subRoot being nnot null, its not a subTree 
         }

         if(root.val==subRoot.val && isSame(root,subRoot)){
            return true; // if root is identified and the trees following them are same, we can conclude it is a subTree
         }

         return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);

    }

    public boolean isSame(TreeNode root, TreeNode subRoot){
        
        if(root==null && subRoot==null){
            return true;
        }

        if(root==null || subRoot==null){
            return false;
        }

        if(root.val!=subRoot.val){
            return false;
        }

        return isSame(root.left,subRoot.left) && isSame(root.right, subRoot.right);
    }


}
