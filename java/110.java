/**
 * 判断是平衡二叉树
 */
class Solution {
    // 时间O(n) 空间O(n)
    public boolean isBalanced(TreeNode root) {
        // 如果返回的高度不是 -1，说明是平衡的
        return height(root) >= 0;
    }

    // 计算树的高度，如果不平衡返回 -1
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 递归计算左子树高度
        int leftHeight = height(root.left);
        // 如果左子树不平衡，直接向上返回 -1，提前剪枝
        if (leftHeight == -1) return -1;

        // 递归计算右子树高度
        int rightHeight = height(root.right);
        // 如果右子树不平衡，直接向上返回 -1，提前剪枝
        if (rightHeight == -1) return -1;

        // 判断当前节点是否平衡
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // 不平衡，返回标记 -1
        }

        // 如果平衡，返回当前树的高度
        return Math.max(leftHeight, rightHeight) + 1;
    }
}