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
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(!lesser(root.left, root.val) || !larger(root.right, root.val)){
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    // 判断当前子树的所有值 是否都小于value
    private boolean lesser(TreeNode root, int value){
        if(root == null) {
            return true;
        }
        // 严格小于 大于或等于就是false
        if(root.val >= value){
            return false;
        }
        return lesser(root.left, value) && lesser(root.right, value);
    }

    // 判断当前子树的所有值 是否都大于value
    private boolean larger(TreeNode root, int value){
        if(root == null) {
            return true;
        }

        // 严格大于 小于或等于就是false
        if(root.val <= value){
            return false;
        }
        return larger(root.left, value) && larger(root.right, value);
    }
}