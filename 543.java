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
    private int ans=0; // 存储直径

    // 规律：直径的开始结束节点一定是叶子节点
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    // 计算root为根的最大链长
    // 链长等于经过的节点的边数量
    private int dfs(TreeNode root){
        if(root == null) return -1;

        // 计算左右子树链长
        int left = dfs(root.left);
        int right = dfs(root.right);

        ans = Math.max(ans, left+ right + 2);//更新直径
        return Math.max(left, right) + 1; //左右子树最大+当前节点
    }
}