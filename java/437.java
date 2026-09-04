/**
 * @description: 二叉树中和等于targetSum的路径数目，路径不一定从根节点开始，也不一定从叶子节点结束，但是方向要向下
 * 思路：参考前缀和的思路，定义节点的前缀和为：由根结点到当前结点的路径上所有节点的和。
 * 找到路径和为targetsum也就是看是否存在两个前缀和(s1比s2更长) s1-s2 = targetSum => s2 = s1-targetSum 符合这个公式的前缀和次数就是路径数目
 */
class Solution {
    private int ans=0;
    // 时间O(n) 空间O(n)
    public int pathSum(TreeNode root, int targetSum) {
        // 存储前缀和的map，key是前缀和，value是出现的次数
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L,1);  // 初始化前缀和为0的次数为1，表示从根节点开始的路径
        dfs(root, 0, targetSum, cnt);
        return ans;
    }
    /**
      * 先序遍历二叉树
      * root 当前树的根节点
      * s当前的路径和 从根到当前节点的路径和
     */
    private void dfs(TreeNode root, long s, int targetSum, Map<Long, Integer> cnt){
        if(root == null){
            return ;
        }

        s += root.val; // 更新当前路径的前缀和
        ans += cnt.getOrDefault(s-targetSum, 0); // 看看之前的路径中有没有前缀和等于 s - targetSum 的，有几个就加上几个答案
        cnt.put(s, cnt.getOrDefault(s,0)+1); // 更新前缀和出现次数

        // 左右子树
        dfs(root.left,s,targetSum,cnt);
        dfs(root.right,s,targetSum,cnt);
        
        // 回溯 cnt恢复原来的值 cnt是类变量
        cnt.put(s, cnt.get(s) - 1);
    }

}