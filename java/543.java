/**
 * @description: 计算二叉树直径(直径是指树中任意两个节点之间最长路径的长度 。这条路径可能经过也可能不经过根节点)
 * [1,2,3,4,5] 输出: 3
 *  任意一条路径必然有一个“最高点”（即深度最浅的那个节点）。这条最长路径可能是“左子树最深处的节点->最高点->右子树最深处的节点”
 *  要把每一个节点当作一次”最高点“,取全局最大值
 */
// 时间O(n) 空间O(h) h为树的高度(logn~n)
class Solution {
    // 存储全局最大直径
    private int ans=0;

    // 规律：直径的开始结束节点一定是叶子节点
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    // 计算root为根的最大链长
    // 链长等于经过的节点的边数量
    private int dfs(TreeNode root){
        // 根结点为空，链长为-1
        if(root == null) return -1;

        // 计算左右子树链长
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        // 更新全局最大直径 左子树链长 + 右子树链长 + 2（当前节点到左右子树的边）
        ans = Math.max(ans, left+ right + 2);
        // 向上返回当前节点的最大链长 （左子树链长和右子树链长的最大值 + 1）
        return Math.max(left, right) + 1;
    }
}