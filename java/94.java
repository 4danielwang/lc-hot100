/**
 * @description: 二叉树的中序遍历
 */
// 时间O(n) 空间O(n)
class Solution {

    // 存储访问结果
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        doInorder(root);
        return ans;
    }

    private void doInorder(TreeNode root) {
        if (root == null)
            return;
        doInorder(root.left);
        ans.add(root.val);
        doInorder(root.right);
    }
}