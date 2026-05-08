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
    
    private List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        // 先序遍历 保存线性表
        preOrder(root);
        // 只需要遍历n-1个节点 最后一个节点是根 left right都是null 无需处理
        for(int i=0;i<list.size()-1;i++){
            TreeNode cur = list.get(i);
            cur.left=null;
            cur.right=list.get(i+1);
        }

    }
    private void preOrder(TreeNode root){
        if(root == null){
            return ;
        }
        list.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }

}