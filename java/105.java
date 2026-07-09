/**
 * @description: 根据前序和中序遍历序列构造二叉树
 * 思路: 前序遍历 [根 [左] [右]] 中序遍历 [[左] 根 [右]] 只要找到中序的根,就能找到左右子树的前序和中序 递归解决
 */
class Solution {

    private Map<Integer, Integer> indexMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 构造哈希映射，帮助我们快速定位根节点
        for(int i=0;i<inorder.length;i++){
            indexMap.put(inorder[i], i);
        }

        int n=preorder.length;
        return buildTree(preorder, inorder, 0, n-1, 0, n-1);

    }

    // 构建子树: preorder[preLeft..preRight]是当前子树的前序遍历序列, inorder[inLeft..inRight]是当前子树的中序遍历序列
    private TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight){
        // 前序序列为空 子树构建完毕
        if(preLeft > preRight){
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int value = preorder[preLeft];
        // 定位根节点在中序遍历中的位置
        int pos = indexMap.get(value);
        // 建立根节点
        TreeNode root = new TreeNode(value);
        
        // 左子树节点个数
        int leftNum = pos-inLeft;
        // 右子树节点个数
        int rightNum = inRight-pos;

        // 递归构造左右子树 更新左右子树的递归的前序和中序遍历的索引范围
        root.left = buildTree(preorder, inorder, preLeft+1, preLeft+leftNum, inLeft, pos-1);
        root.right = buildTree(preorder, inorder, preLeft+leftNum+1, preRight, pos+1, inRight);
        return root;
    }
}