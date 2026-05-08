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
    private int ans = 0;
    public int sumNumbers(TreeNode root) {
        dfs(0, root);
        return ans;
    }

    // currentSum: 当前访问到的位置的路径数字之和
    private void dfs(int currentSum, TreeNode root){
        if(root == null){
            return;
        }
        // 访问节点 更新当前sum
        currentSum = currentSum * 10 + root.val;

        // 若叶子节点 更新ans
        if(root.left == null && root.right==null){
            ans += currentSum;
            return ;
        }
        
        // 递归左右子树
        dfs(currentSum, root.left);
        dfs(currentSum, root.right);
    }
}