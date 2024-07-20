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

 class Pair {
    TreeNode node;
    int level;

    Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        // We need to keep track of nodes at each level
        List<TreeNode> currentLevelNodes = new ArrayList<>();
        int currentLevel = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            currentLevelNodes.clear();
            
            // Process nodes level by level
            for (int i = 0; i < size; i++) {
                Pair p = q.remove();
                TreeNode curr = p.node;
                int level = p.level;
                
                // Add nodes to the list for the current level
                currentLevelNodes.add(curr);
                
                // Add children to the queue
                if (curr.left != null) {
                    q.add(new Pair(curr.left, level + 1));
                }
                if (curr.right != null) {
                    q.add(new Pair(curr.right, level + 1));
                }
            }
            
            // If current level is odd, reverse the values of nodes
            if (currentLevel % 2 == 1) {
                int left = 0, right = currentLevelNodes.size() - 1;
                while (left < right) {
                    int temp = currentLevelNodes.get(left).val;
                    currentLevelNodes.get(left).val = currentLevelNodes.get(right).val;
                    currentLevelNodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }
            currentLevel++;
        }
        
        return root;
    }
}
