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
    // 最大路径和初始化为负无穷
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    // 计算root为根的路径和
    // 计算每个转弯点
    private int dfs(TreeNode root){
        // 当前节点为空 路径和为0
        // 路径和=左边路径和+右边路径和+当前节点
        if(root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
       
        ans = Math.max(ans, left+right+root.val);
        return Math.max(Math.max(left,right) + root.val , 0);
       
    }


}