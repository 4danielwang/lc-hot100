/**
 * @description: 搜索二维矩阵 II, 每行元素从左到右升序排列，每列元素从上到下升序排列。编写一个高效的算法来搜索 m x n
 *               矩阵中的一个目标值
 *               思路: 从右上角开始搜索,当成BST搜索, 往左都是比当前节点小的(左子树),往下都是比当前节点大的(右子树)
 */
class Solution {
    // 时间O(m+n) 空间O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;

        // 从右上角搜索到左下角
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            // target比当前大 走右子树(向下) 否则左子树(向左)
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }

        return false;
    }
}