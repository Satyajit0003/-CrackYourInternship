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
 class Pair{
    TreeNode root;
    int level;

    Pair(TreeNode root,int level){
        this.root=root;
        this.level=level;
    }
 }
class Solution {
    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0; // If tree is empty, its height is 0
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public int deepestLeavesSum(TreeNode root) {
        int height=findHeight(root);
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,1));
        int sum=0;
        while(!q.isEmpty()){
            Pair p=q.remove();
            TreeNode currNode=p.root;
            int l=p.level;

            if(l==height){
                sum+=currNode.val;
            }
            if(currNode.left!=null){
                q.add(new Pair(currNode.left,l+1));
            }
            if(currNode.right!=null){
                q.add(new Pair(currNode.right,l+1));
            }
        }
        return sum;
    }
}