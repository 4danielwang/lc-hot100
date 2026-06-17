/**
 * @description: 从m x n网格中找到一条左上角到右下角的路径, 使得路径上的数字总和为最小。(每次只能向下或者向右移动一步)
 *               dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
 *               空间优化:滚动数组,dp[i][j]只与dp[i-1][j]和dp[i][j-1]有关
 */
class Solution {

    // 时间O(mn) 空间O(1)
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 第一行只能从左边过来 dp[i][j] = grid[i][j] + dp[i][j-1]
                if (i == 0)
                    grid[i][j] += grid[i][j - 1];
                // 第一列只能从上边过来 dp[i][j] = grid[i][j] + dp[i-1][j]
                else if (j == 0)
                    grid[i][j] += grid[i - 1][j];
                // 普通格子 dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
                else
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    // 时间O(mn) 空间O(n)
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp 数组代表当前行的状态
        int[] dp = new int[n];

        // 1. 初始化第一行
        dp[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        // 2. 从第二行开始向下遍历
        for (int i = 1; i < m; i++) {
            // 第一列的元素只能从上面下来
            dp[0] = dp[0] + grid[i][0];

            // 遍历当前行的其他元素
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }

        return dp[n - 1];
    }
}