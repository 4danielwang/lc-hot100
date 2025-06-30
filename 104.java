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
    private int ans = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    private int dfs(TreeNode root, int height){
        if(root==null)
            return 0;
        int left=dfs(root.left, height + 1);
        int right = dfs(root.right, height +1);
        ans = Math.max(ans, Math.max(left, right) +1);
        return Math.max(left, right) + 1;
    }

}
