/**
 * @description: 最大正方形：由0和1组成的二维矩阵，找出只包含1的最大正方形，并返回其面积。
 * 思路：动态规划，dp[i][j]代表以i,j为右下角的正方形的最大变长，正方形内部全是1，面积等于最大边长的平方
 * 空间优化： 滚动数组，dp[i][j]只依赖于dp[i-1][j-1], dp[i][j-1], dp[i-1][j]，只与上一行和当前行有关，所以可以使用滚动数组优化空间复杂度
 */
class Solution {
    // 时间O(rows * cols) 空间O(cols)
    public int maximalSquare(char[][] matrix) {
        
        int ans = 0; // 记录最大边长
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(matrix == null || rows == 0 || cols == 0)
            return ans;

        // int[][] dp = new int[rows][cols];

        // 初始化第一行
        // for (int j = 0; j < cols; j++) {
        //     if (matrix[0][j] == '1') {
        //         dp[0][j] = 1;
        //         ans = 1; // 只要第一行有1，最大面积至少为1
        //     }
        // }

        // 单独初始化第一列
        // for (int i = 0; i < rows; i++) {
        //     if (matrix[i][0] == '1') {
        //         dp[i][0] = 1;
        //         ans = 1; // 只要第一行有1，最大面积至少为1
        //     }
        // }


        // for (int i = 1; i < rows; i++) {
        //     for (int j = 1; j < cols; j++) {
        //         if (matrix[i][j] == '1') {
        //             // 取决于左边、左上、上边的三个位置的最短边长 + 1
        //             dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
                    
        //             // 更新最大边长记录
        //             ans = Math.max(ans, dp[i][j]);
        //         }
        //     }
        // }
        // return ans * ans;

        int[][] dp = new int[2][cols]; // 只保存当前行和上一行

        // 初始化第一行
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                ans = 1;
            }
        }
        
        // 滚动数组优化
        for (int i = 1; i < rows; i++) {
            int curr = i % 2; // 当前行
            int prev = (i - 1) % 2; // 上一行
           
            // 注意：滚动数组不要忘记初始化第一列
            if (matrix[i][0] == '1') {
                dp[curr][0] = 1;
                ans = Math.max(ans, 1);
            } else {
                dp[curr][0] = 0;
            }
            
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    // 取决于左边、左上、上边
                    dp[curr][j] = Math.min(Math.min(dp[prev][j-1], dp[curr][j-1]), dp[prev][j]) + 1;
                    ans = Math.max(ans, dp[curr][j]);
                } else {
                    dp[curr][j] = 0; // 注意：滚动数组必须清零
                }
            }
        }
        return ans * ans;

    }
}