/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // root是p或者q 他就是公共祖先
        // 如果root空 就返回空 不存在
        if(root==p || root==q || root==null)
            return root;
        // 在左子树找最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 左右子树都有，pq各分布一边
        if(left!=null && right!=null)
            return root; 
        if(left!=null)
            return left;
        else
            return right;
    }
}