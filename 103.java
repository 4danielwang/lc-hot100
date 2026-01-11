import java.util.Collections;

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

    // 与102的区别：偶数层翻转，奇数层不变
    // 时间O(n) 空间O(n)
     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         // 树为空 返回[]
        if(root==null)
            return new ArrayList<>();
        
        List<List<Integer>> ans=new ArrayList<>();
       
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 标记当前层是否是从左向右
        boolean leftToRight = true;
    

        while(!queue.isEmpty()){
            // 当前层的值 双向队列
            List<Integer> vals = new LinkedList<>();

            // 当前队列的长度为当前层的元素个数
            int len = queue.size();
            for(int i=0;i<len;i++){
                TreeNode node = queue.remove();
                if(leftToRight){
                    vals.addLast(node.val);
                }else{
                    vals.addFirst(node.val);
                }
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            ans.add(vals);
            leftToRight = !leftToRight; // 每一层结束，切换方向
        }
       
        return ans;

    }
    
}