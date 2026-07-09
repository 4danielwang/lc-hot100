/**
 * @description: 给定二叉树,计算每一层的最大宽度,最大宽度是指该层最左和最右非空节点之间的长度(包括null节点)
 *               思路: BFS层序遍历
 *               如果给二叉树编号,i的左子树编号是2*i,右子树编号是2*i+1,层序遍历每一层,最大宽度=最大编号-最小编号+1
 */
class Solution {
    // 时间O(n) 空间O(n)
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        // 用Pair对象给每个节点额外编号
        // 当前队列
        List<Pair<TreeNode, Integer>> cur = new ArrayList<>();

        // root入队
        cur.add(new Pair<>(root, 1));

        while (!cur.isEmpty()) {
            // 下一层的节点队列
            List<Pair<TreeNode, Integer>> next = new ArrayList<>();
            // 访问当前队列
            for (Pair<TreeNode, Integer> pair : cur) {
                TreeNode t = pair.getKey();
                Integer nodeNum = pair.getValue();

                // 如果有左右子树 入队
                if (t.left != null) {
                    next.add(new Pair<>(t.left, 2 * nodeNum));
                }
                if (t.right != null) {
                    next.add(new Pair<>(t.right, 2 * nodeNum + 1));
                }
            }
            // 当前层宽度=最大编号-最小编号+1
            ans = Math.max(ans, cur.get(cur.size() - 1).getValue() - cur.get(0).getValue() + 1);
            cur = next;
        }
        return ans;
    }
}