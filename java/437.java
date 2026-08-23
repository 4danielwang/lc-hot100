/**
 * @description: 二叉树中和等于targetSum的路径数目，路径不一定从根节点开始，也不一定从叶子节点结束，但是方向要向下
 * 思路：参考前缀和的思路，节点的前缀和:根结点到当前结点的路径上所有节点的和，也就是从根节点到当前节点的路径和减去targetSum，看看之前有没有出现过这个值，如果出现过，那么说明存在一条路径和为targetSum
 */
class Solution {
    private int ans=0;
    // 时间O(n) 空间O(n)
    public int pathSum(TreeNode root, int targetSum) {
        // 存储前缀和的map，key是前缀和，value是出现的次数
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L,1);
        dfs(root, 0, targetSum, cnt);
        return ans;
    }
    /**
      * root 当前树的根节点
      * s当前的路径和 从根到当前节点的路径和
     */
    private void dfs(TreeNode root, long s, int targetSum, Map<Long, Integer> cnt){
        if(root == null){
            return ;
        }

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