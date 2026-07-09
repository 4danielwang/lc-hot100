/**
 * @description: 给一个二叉树,统计所有根节点到叶子结点的访问路径的字符串的数字之和
 * 思路: dfs从root开始访问所有的节点,用pathSum记录当前路径的数字,当访问到叶子结点累加这个数字到ans
 */
class Solution {
    // 记录当前已经统计的路径数字和
    private int ans = 0;
    public int sumNumbers(TreeNode root) {
        dfs(0, root);
        return ans;
    }

    // pathSum: 当前访问的路径数字之和
    private void dfs(int pathSum, TreeNode root){
        if(root == null){
            return;
        }
        // 访问节点 更新当前sum
        pathSum = pathSum * 10 + root.val;

        // 叶子节点 找到一个路径数字 累加到ans
        if(root.left == null && root.right==null){
            ans += pathSum;
            return ;
        }
        
        // 递归左右子树
        dfs(pathSum, root.left);
        dfs(pathSum, root.right);
    }
}