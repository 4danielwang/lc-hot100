/**
 * @description: 翻转二叉树，每个root的左右子树交换, 返回翻转后的根节点
 */
class Solution {
    // 时间O(n) 空间O(n)
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        // 需要先计算出翻转后的左右子树根节点
        // 因为后续要用到root.right 这里不能直接修改
        TreeNode newRight = invertTree(root.left);
        TreeNode newLeft = invertTree(root.right);
        // 交换左右子树
        root.right = newRight;
        root.left  = newLeft;
        return root;
    }
}