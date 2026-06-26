/**
 * @description: 验证是否是一个有效的BST二叉搜索树
 * 思路：递归判断或者中序遍历判断
 */
class Solution {
    // 时间O(n) 空间O(n)
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 判断node子树中所有节点的值是否都在 (lower,upper)范围 
    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        // 当前node的值在(lower,upper)范围内，继续判断左右子树
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}