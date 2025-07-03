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
    public boolean isValidBST(TreeNode root) {
        // BST中序序列有序
        midVisit(root);
        // 小于2个直接返回
        if(ans.size() < 2) return true;
        
        // i最多取到倒数第二个
        for(int i=0;i<ans.size()-1;i++){
            // 必须严格递增 不可以相等
            if(ans.get(i)>=ans.get(i+1)){
                return false;
            }
        }
    
        return true;
    }
    private void midVisit(TreeNode root){
        if(root==null) return ;
        if(root.left!=null){
            midVisit(root.left);
        }
        ans.add(root.val);
        
        if(root.right != null){
            midVisit(root.right);
        }
    }
  
}/**
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
    public boolean isValidBST(TreeNode root) {
        // BST中序序列有序
        midVisit(root);
        // 小于2个直接返回
        if(ans.size() < 2) return true;
        
        // i最多取到倒数第二个
        for(int i=0;i<ans.size()-1;i++){
            // 必须严格递增 不可以相等
            if(ans.get(i)>=ans.get(i+1)){
                return false;
            }
        }
    
        return true;
    }
    private void midVisit(TreeNode root){
        if(root==null) return ;
        if(root.left!=null){
            midVisit(root.left);
        }
        ans.add(root.val);
        
        if(root.right != null){
            midVisit(root.right);
        }
    }

    // 方法2: 边访问边记录值
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
    // 记录中序遍历过程当前访问节点值
    // 由于-2^31 <= Node.val <= 2^31 - 1
    // 考虑边界条件 root值取到-2^31就判断不是递增了 需要用更大的初始值
    private long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(!isValidBST(root.left)){ // 左
            return false;
        }
        // 中
        if(pre >= root.val){
            return false;
        }
        pre = root.val;
        // 右
        return isValidBST(root.right);
    }

  
}
  
}