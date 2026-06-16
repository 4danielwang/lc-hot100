/**
 * @description: [1...n]根据字典序排序，第K小的数字
 * 输入 n=13,k=2 排序[1,10,11,12,13,2,3,4,5,6,7,8,9] 输出 10
 * 前缀树（十叉树） 1-9为第一层，10-19为第二层，100-199为第三层，以此类推
 * 十叉树的先序遍历结果就是字典序排序的结果 [1,10,11,12....2,20,21...] (需要加一个<=n的限制)
 */
class Solution {
    // 时间复杂度 O(log(n)^2)，空间复杂度 O(1)
    public int findKthNumber(int n, int k) {
        // curr是当前节点，需要知道curr为前缀的子树中，一共包含多少个<=n的节点（steps)
        int curr = 1;
        k--; // 已经确定了第一个节点是1，剩余还需要找 k-1 个节点

        // 循环直到k=0
        while (k > 0) {
            // 当前子数节点总数
            int steps = getSteps(curr, n);
            // 节点不在以 curr 为根的子树中（这个子树小于n的节点个数不足k个），剪枝（跳过）
            if (steps <= k) {
                curr++; // 先序遍历，访问下一个兄弟节点
                k -= steps;
            } else {
                // 节点在以 curr 为根的子树中，进入下一层
                curr *= 10;
                k--;
            }
        }
        return curr;
    }

    // 计算以 curr 为根，<= n 的节点总数
    private int getSteps(int curr, long n) {
        int steps = 0;
        // 当前层的第一个节点
        long first = curr;
        // 当前层的最后一个节点
        long last = curr; // 使用 long 防止 *10 后溢出
        
        while (first <= n) {
            // 每一层的节点总数 = min(n, last) - first + 1
            steps += Math.min(n, last) - first + 1;
            // 下一层的第一个节点
            first = first * 10;
            // 下一层的最后一个节点
            last = last * 10 + 9;
        }
        return steps;
    }
}