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
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        dfs(root,path,targetSum);
        return ans;   
    }

    private void dfs(TreeNode root, List<Integer> path, int left){
        if(root == null){
            return;
        }
        // 访问当前root节点
        path.add(root.val); 
        // 访问后就更新left
        left -= root.val;
        // 叶子结点 并且left=0 就是一个路径
        if(root.left == null && root.right == null && left == 0){
            ans.add(new ArrayList<>(path)); // 拷贝
        }else{ // 没找到路径 继续递归
            dfs(root.left, path, left);
            dfs(root.right, path, left);
        }
        path.remove(path.size()-1); // 回溯
    }
}