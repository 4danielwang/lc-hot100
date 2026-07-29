/**
 * @description: 二叉树的最大深度(从根节点到最远叶子节点的最长路径上的节点数)
 * 思路：DFS，以root为根的树的最大深度 = max(左子树的最大深度, 右子树的最大深度) + 1
 */
class Solution {
    // 时间O(n) 空间O(h)
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
