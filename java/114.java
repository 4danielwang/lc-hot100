/**
 * @description: 将二叉树展开为链表
 * 思路：先序遍历二叉树，保存到一个线性表中, 然后遍历线性表，修改每个节点的左右指针
 */
class Solution {
    
    private List<TreeNode> list = new ArrayList<>();
    // 时间O(n) 空间O(n)
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