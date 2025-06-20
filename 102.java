import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

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
    // 方法一、两个数组分别记录相邻的两层
    public List<List<Integer>> levelOrder1(TreeNode root) {
        // 树为空 返回[]
        if(root==null)
            return new ArrayList<>();
        
        List<List<Integer>> ans=new ArrayList<>();
        List<TreeNode> cur = List.of(root);

        // cur数组为当前层遍历节点
        // next数组为下一层的节点
        // 更新next为cur就是向下一层移动
        while(!cur.isEmpty()){
            List next = new ArrayList<>();
            List<Integer> vals = new ArrayList<>();
            for(TreeNode x : cur){
                if(x.left!=null) next.add(x.left);
                if(x.right!=null) next.add(x.right);
                vals.add(x.val);
            }
            cur=next;
            ans.add(vals);
        }
        return ans;

    }

       // 方法一、队列
    public List<List<Integer>> levelOrder(TreeNode root) {
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
            ans.add(vals);
        }
       
        return ans;

    }
}