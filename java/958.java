/**
 * @description: 判断一棵二叉树是否为完全二叉树。完全二叉树判断: 根编号v，左子树编号2v，右子树编号2v+1，最后一个节点的编号应该等于节点总数
 * BFS
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        // BFS层序遍历，给每个节点编号
        List<ANode> nodes = new ArrayList();
        nodes.add(new ANode(root, 1));
        int i = 0;
        while (i < nodes.size()) {
            ANode anode = nodes.get(i++);
            if (anode.node != null) {
                nodes.add(new ANode(anode.node.left, anode.code * 2));
                nodes.add(new ANode(anode.node.right, anode.code * 2 + 1));
            }
        }
        // 如果是从1开始编号的完全二叉树，那么最后一个节点的编号应该等于节点总数
        return nodes.get(i-1).code == nodes.size();
    }
}
// 节点
class ANode {
    TreeNode node;
    int code;
    ANode(TreeNode node, int code) {
        this.node = node;
        this.code = code;
    }
}