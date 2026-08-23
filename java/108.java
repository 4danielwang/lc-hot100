/**
 * @description: 将有序数组转换为高度平衡的二叉搜索树
 * 思路：递归，取中间节点作为根节点，左边的作为左子树，右边的作为右子树
 */
class Solution {
    // 时间O(n) 空间O(logn)
    public TreeNode sortedArrayToBST(int[] nums) {
       return buildTree(0, nums.length-1, nums);
    }

    // 中序遍历 选择中间位置作为根节点
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