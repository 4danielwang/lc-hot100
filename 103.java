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
     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         // 树为空 返回[]
        if(root==null)
            return new ArrayList<>();
        
        List<List<Integer>> ans=new ArrayList<>();
       
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
    

        while(!queue.isEmpty()){
            List<Integer> vals = new ArrayList<>();
            // 当前队列的长度为当前层的元素个数
            int len = queue.size();
            for(int i=0;i<len;i++){
                TreeNode node = queue.remove();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                vals.add(node.val);
            }
            // 第一层 ans.size()=0
            // 第二层 ans.size()=1
            if(ans.size() % 2 != 0)
                Collections.reverse(vals);
            ans.add(vals);
        }
       
        return ans;

    }
    
}