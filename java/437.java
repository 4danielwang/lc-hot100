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
    private int ans=0;
    // s[i] = target - s[j]
    public int pathSum(TreeNode root, int targetSum) {
        // 路径和 可能溢出integer范围
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L,1);
        dfs(root, 0, targetSum, cnt);
        return ans;
    }
    /**
      * root 当前树的根节点
      * s 当前的路径和 相当于s[j]
     */
    private void dfs(TreeNode root, long s, int targetSum, Map<Long, Integer> cnt){
        if(root == null){
            return ;
        }

        // 路径和
        s += root.val;
        ans += cnt.getOrDefault(s-targetSum, 0);
        cnt.put(s, cnt.getOrDefault(s,0)+1);

        // 左右子树
        dfs(root.left,s,targetSum,cnt);
        dfs(root.right,s,targetSum,cnt);
        
        // 回溯 cnt恢复原来的值 cnt是类变量
        cnt.put(s, cnt.get(s) - 1);
    }

}