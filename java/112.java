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
    // 时间复杂度O(n) 空间O(n)
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 空树
        if(root == null){
            return false;
        }
        // 更新targetSum 已访问
        targetSum -= root.val;
        // 叶子结点
        if(root.left == null && root.right == null) {
            return targetSum == 0; // 返回true的条件
        }
        // 递归处理左右子树
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}