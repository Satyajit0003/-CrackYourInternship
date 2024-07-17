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
    public void ReverseInOrder(TreeNode root){
         if(root==null){
            return;
         }
         ReverseInOrder(root.right);
         sum+=root.val;
         root.val=sum;
         ReverseInOrder(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        ReverseInOrder(root);
        return root;
    }
}