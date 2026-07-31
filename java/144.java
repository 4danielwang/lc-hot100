/**
 * @description: 二叉树的前序遍历
 */
class Solution {
    private List<Integer> ans = new ArrayList<>();
    // 时间O(n) 空间O(n)
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return ans;        
    }

    private void preorder(TreeNode root){
        if(root == null){
            return;
        }
        ans.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}