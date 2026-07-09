/**
 * @description: 判断二叉树是否是对称的
 * 思路: 利用双指针,p和q朝着反方向移动,检查p和q是否相等,如果相等继续移动,再判断他们的左右子树是否对称
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    // 判断两个子树是否互为镜像
    private boolean check(TreeNode p, TreeNode q) {
        // 如果p和q都为空,说明是对称的
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        // 镜像判断: p和q根相等, p的左子树和q的右子树互为镜像, p的右子树和q的左子树互为镜像
        return p.val == q.val && check(p.right, q.left) && check(p.left, q.right);
    }
}