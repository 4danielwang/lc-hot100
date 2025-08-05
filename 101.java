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
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }
    
    // 辅助函数 判断两个树 是否轴对称（镜像对称）
    // a，b是当前子树的根节点指针
    // a,b 两个树 轴对称
    // 1、a,b根节点相等 2、a左子树与b右子树互为轴对称,a右子树与b左子树互为轴对称
    private boolean check(TreeNode a, TreeNode b){
        if(a == null && b == null){
            return true;
        }
        if(a == null || b == null){
            return false;
        }
        return a.val == b.val && check(a.right, b.left) && check(a.left, b.right);
    }
}