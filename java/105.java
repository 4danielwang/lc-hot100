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

    // 值到index的映射 实现O(1)查询
    private Map<Integer, Integer> valueToIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            valueToIndexMap.put(inorder[i], i);
        }

        int n=preorder.length;
        return buildTree(preorder, inorder, 0, n-1, 0, n-1);

    }

    // 构建子树
    private TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight){
        // 子树构建完毕
        if(preLeft > preRight){
            return null;
        }

        // 先序 第一个节点是根节点
        int value = preorder[preLeft];
        TreeNode root = new TreeNode(value);
        
        // 定位在根节点在中序的位置
        int pos = valueToIndexMap.get(value);
        // 左子树个数
        int leftNum = pos-inLeft;
        // 右子树个数
        int rightNum = inRight-pos;

        root.left = buildTree(preorder, inorder, preLeft+1, preLeft+leftNum, inLeft, pos-1);
        root.right = buildTree(preorder, inorder, preLeft+leftNum+1, preRight, pos+1, inRight);
        return root;
    }
}