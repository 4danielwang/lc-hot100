/**
 * @description: 二叉搜索树中第K小的元素
 * 思路：中序遍历
 */
class Solution {
    private List<Integer> ans = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        // 中序遍历就是从小到大
        inOrder(root);
        return ans.get(k-1);
    }

    private void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        ans.add(root.val);
        inOrder(root.right);
    }
}