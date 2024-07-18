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
    public int count=0;
    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return count;
    }
    int postOrder(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=postOrder(root.left);
        int right=postOrder(root.right);
        int n=left+right+1;
        int sum=0;
        sum+=root.val;
        if(root.left!=null){
            sum+=root.left.val;
        }
        if(root.right!=null){
            sum+=root.right.val;
        }

        int average=sum/n;
        if(root.val==average){
            count++;
        }
        root.val=sum;
        
        return left+right+1;
    }
}