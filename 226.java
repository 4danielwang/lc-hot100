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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        // 需要先计算出反转后的左右子树根节点
        // 因为后续要用到root.right 这里不能直接修改
        TreeNode newRight = invertTree(root.left);
        TreeNode newLeft = invertTree(root.right);
        root.right = newRight;
        root.left  = newLeft;
        return root;
    }
}