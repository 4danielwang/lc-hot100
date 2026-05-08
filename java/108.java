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
    public TreeNode sortedArrayToBST(int[] nums) {
        // 求中间节点 向下取整（取左边的）
        // 左右都是闭区间
       return buildTree(0, nums.length-1, nums);
    }

    private TreeNode buildTree(int left, int right, int[] nums){
        if(left <= right){
            int mid = left + (right-left)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildTree(left, mid-1, nums);
            root.right = buildTree(mid+1, right, nums);
            return root;
        }
        return null;
    }

}