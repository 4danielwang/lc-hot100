/**
 * @description: 从m x n网格中找到一条左上角到右下角的路径, 使得路径上的数字总和为最小。(每次只能向下或者向右移动一步)
 *               dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1]) 表示[0,0]到[i,j]的最小路径和
 *               空间优化:滚动数组,dp[i][j]只与dp[i-1][j]和dp[i][j-1]，只需要2行
 */
class Solution {

    // 时间O(mn) 空间O(n)
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
    
        // int[][] dp = new int[m][n];
        int[][] dp = new int[2][n]; // 滚动数组,只需要2行
        dp[0][0] = grid[0][0]; // 初始化条件

        // 处理第一列 (只能从上面过来，累加即可)
        // for(int i = 1; i < m; i++){
        //     dp[i][0] = dp[i-1][0] + grid[i][0];
        // }
        
        // 处理第一行 (只能从左边过来，累加即可)
        for(int j = 1; j < n; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        
        // 剩下的可以从上面或者左边过来，取最小值
        // for(int i = 1; i < m; i++){
        //     for(int j = 1; j < n; j++){
        //         dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
        //     }
        // }


        for(int i = 1; i < m; i++){
            int curr = i % 2; // 当前行
            int prev = (i - 1) % 2; // 上一行

            // 滚动数组，需要重新计算第一列
            dp[curr][0] = dp[prev][0] + grid[i][0];
            for(int j = 1; j < n; j++){
                dp[curr][j] = Math.min(dp[prev][j], dp[curr][j-1]) + grid[i][j];
            }
        }
        
        // 最后一行行号是 (m-1)%2
        return dp[(m-1)%2][n-1];
    }
}