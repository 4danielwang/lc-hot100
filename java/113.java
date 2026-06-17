import java.util.Deque;

/**
 * @description: 根据二叉树root节点和targetSum,找到路经总和(根节点到叶子节点)等于targetSum的所有路径列表
 */
class Solution {
    // 所有的路径
    private List<List<Integer>> ans = new ArrayList<>();

    // 记录当前路径
    Deque<Integer> path = new LinkedList<Integer>();

    // 时间O(n^2) 空间O(n)
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ans;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        // 访问当前root节点
        path.offerLast(root.val);
        // 访问后就更新targetSum
        targetSum -= root.val;
        // 叶子结点 并且targetSum=0 就是一个路径
        if (root.left == null && root.right == null && targetSum == 0) {
            ans.add(new ArrayList<>(path)); // 不能直接添加path 因为path是引用类型 会被后续的回溯修改
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.pollLast(); // 回溯
    }
}