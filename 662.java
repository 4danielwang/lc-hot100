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
    // 层序遍历，找节点数最多的层
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        // 用Pair对象给每个节点额外编号 符合满二叉树编号规律
        // 根是i 左节点2*i 右节点2*i+1

        // 当前队列
        List<Pair<TreeNode, Integer>> cur = new ArrayList<>();
        cur.add(new Pair<>(root, 1));

        while(!cur.isEmpty()){
            // 下一层的节点队列
            List<Pair<TreeNode, Integer>> next = new ArrayList<>();
            // 访问当前队列
            for(Pair<TreeNode,Integer> pair : cur){
                TreeNode t = pair.getKey();
                Integer nodeNum = pair.getValue();

                // 如果有左右子树 入队
                if(t.left != null){
                    next.add(new Pair<>(t.left, 2*nodeNum));
                }
                if(t.right != null){
                    next.add(new Pair<>(t.right, 2*nodeNum+1));
                }
            }
            // 找到当前层的最大值和最小值
            // 由于是层序遍历 最小值是第一个 最大值是倒数第一
            ans = Math.max(ans,cur.get(cur.size()-1).getValue()-cur.get(0).getValue()+1);
            cur = next;
        }
        return ans;
    }
}