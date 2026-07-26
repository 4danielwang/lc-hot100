/**
 * @description: 二叉树中的最大路径和(路径不一定经过根节点)
 * 思路：dfs 路径和=左边路径和+右边路径和+当前节点
 * 注意：计算最大路径和需要考虑当前节点的左右子树贡献值；dfs向上返回只需要返回左右子树贡献值中较大的一个加上当前节点的值
 */
class Solution {
    // 时间O(n) 空间O(n)
    private int maxSum = Integer.MIN_VALUE; // 初始化最大路径和为一个很小的数
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    // 从root节点出发，只能选择一个分支得到的最大路径和
    private int maxGain(TreeNode root){
        // 当前节点为空 路径和为0
        if(root == null)
            return 0;
        // 递归计算左右子树的最大路径和 只有贡献大于0才选择这个路径
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
       
        // 节点的最大路径和 = 左子树最大路径和 + 右子树最大路径和 + 当前节点值
        int newMaxSum = leftGain + rightGain + root.val;
        maxSum = Math.max(maxSum, newMaxSum);
        // 向上返回时，只能选择一个分支，所以返回左右子树贡献值中较大的一个加上当前节点的值
        return root.val + Math.max(leftGain, rightGain);
       
    }


}