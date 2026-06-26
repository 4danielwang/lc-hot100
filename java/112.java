/**
 * @description: 判断是否能在二叉树中找到一个从root到根节点的路径，路径和等于targetSum
 */
class Solution {
    // 时间复杂度O(n) 空间O(logn~n)
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        // 叶子节点
        if(root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        // 递归处理左右子树
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}