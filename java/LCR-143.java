/**
 * @description: 子结构判断.两个二叉树tree1和tree2,判断tree2是否以tree1的某个节点为根的子树有相同的结构和值
 *               规定: 空树不是任意一个树的子结构
 */
class Solution {
    // 时间 O(m*n) 空间 O(m)
    public boolean isSubStructure(TreeNode tree1, TreeNode tree2) {
        // 如果 tree1 是空的，或者 tree2 是空的，直接返回 False
        if (tree1 == null || tree2 == null) {
            return false;
        }
        // 三个条件满足一个即可：
        // 1. tree2 是以当前 tree1 为根的子结构
        // 2. tree2 是 tree1 左子树里的子结构
        // 3. tree2 是 tree1 右子树里的子结构
        return dfs(tree1, tree2) ||
                isSubStructure(tree1.left, tree2) ||
                isSubStructure(tree1.right, tree2);
    }

    // 同时往下遍历 tree1 和 tree2，看看接下来的结构和值是否完全一致
    private boolean dfs(TreeNode node1, TreeNode node2) {
        // node2 走到了尽头，说明前面的节点都匹配成功了
        if (node2 == null)
            return true;
        // node1 走到了尽头，或者值不匹配，直接 false
        if (node1 == null || node1.val != node2.val)
            return false;

        // 递归检查左右子树是否同步匹配
        return dfs(node1.left, node2.left) && dfs(node1.right, node2.right);
    }
}