/**
 * @description: 二叉树右视图，从顶部到底部，返回从右侧能看到的节点序列
 * 思路：DFS 先递归右子树，再递归左子树，当某个深度首次访问的节点在右视图中
 */
class Solution {
    // 时间O(n) 空间O(h)～O(n) h是树高
    public List<Integer> rightSideView(TreeNode root) {
        // ans存储右视图的节点值
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode root, int depth, List<Integer> ans) {
        if (root == null) {
            return;
        }
        // 这个深度首次访问的节点就是右视图中的节点
        if (depth == ans.size()) { 
            ans.add(root.val);
        }
        // 先递归右子树，保证首次遇到的一定是最右边的节点
        dfs(root.right, depth + 1, ans);
        dfs(root.left, depth + 1, ans);
    }
}