public /**
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
    // 检查2个子树是否镜像
    private boolean check(TreeNode p, TreeNode q){
        // 节点相等
        if(p == null && q==null){
            return true;
        }
        // 节点不等
        if(p == null || q == null){
            return false;
        }
        // 检查两个节点相等
        // 递归指针方向是反的 p和q左右反的
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
} {
    
}
