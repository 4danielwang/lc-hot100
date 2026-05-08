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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        // 判断root为根左右子树是否平衡
        // 平衡：左右子树高度差<=1
        if(Math.abs(height(root.left)-height(root.right)) <= 1){
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }


    // 计算当前树高 ： 左右子树最大高度+1
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}