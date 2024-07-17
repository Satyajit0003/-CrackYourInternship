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
    public int sum=0;
    public void ReversePreOrder(TreeNode root){
         if(root==null){
            return;
         }
         ReversePreOrder(root.right);
         sum+=root.val;
         root.val=sum;
         ReversePreOrder(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        ReversePreOrder(root);
        return root;
    }
}