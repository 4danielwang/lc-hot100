/**
 * @description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先（一个节点也可以是它自己的祖先）
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    // 时间O(N) 空间O(N)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果p或者q等于root 表示找到了p或者q 直接返回这个节点
        // 如果root空没找到 就返回空
        if(root==p || root==q || root==null)
            return root;
        // 在左子树递归查找p或q 返回非null表示找到p或q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 在右子树递归查找p或q
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 左右子树都有找到p或q
        if(left!=null && right!=null)
            return root;
        // 仅左子树有
        if(left!=null)
            return left;
        else // 仅右子树有
            return right;
    }
}