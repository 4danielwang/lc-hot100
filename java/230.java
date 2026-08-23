/**
 * @description: 二叉搜索树中第K小的元素
 * 思路：中序遍历
 */
class Solution {
    private List<Integer> ans = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        // 中序遍历就是从小到大
        inOrder(root, k);
        return ans.get(k-1);

    }

    private void inOrder(TreeNode root, int k){
        if(root == null) return;
        inOrder(root.left, k);
        ans.add(root.val);
        inOrder(root.right, k);
    }
}