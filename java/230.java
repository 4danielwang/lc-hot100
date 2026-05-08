/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
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