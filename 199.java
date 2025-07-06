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
    
    // 层序遍历 每一层最后一个节点
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {

        if(root==null) return ans;

        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);

        while(!cur.isEmpty()){
            // 下一层的节点
            List<TreeNode> next = new ArrayList<>();
            // 先进先出
            for(int i=0;i<cur.size();i++){
                TreeNode node = cur.get(i); // 当前访问节点
                if(node.left!=null){
                    next.add(node.left);
                }
                if(node.right != null){
                    next.add(node.right);
                }
                // visit 当前层最后一个节点
                if(i == cur.size()-1){
                    ans.add(node.val);
                }
            }
            cur = next;

        }
        return ans;
    }

}