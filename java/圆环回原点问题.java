/**
 * @description: 圆环上有10个点（0-9），从0点出发，每次可以顺时针或者逆时针移动1步，走n步回到0点有多少解法
 * dp[i][j]表示从0点出发走i步到达j点的解法数 dp[i][j] = dp[i-1][(j-1+10)%10] + dp[i-1][(j+1)%10] %10因为可能会超过0-9范围
 * 空间优化：dp[i][j]只与dp[i-1][j]有关，所以可以使用滚动数组优化空间
 */
class Solution {
    // 时间O(mn) 空间O(1)
    public int backToOrigin(int n) {
        int length = 10;
        // dp[i][j] 表示从 0 点出发走 i 步，到达 j 点的解法数
        // int[][] dp = new int[n + 1][length];
        int[][] dp = new int[2][length]; // 使用滚动数组优化空间

        
        // 初始状态：走 0 步停在 0 点的方案数是 1
        dp[0][0] = 1;
        
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 0; j < length; j++) {
        //         // 核心状态转移方程：
        //         // 当前点 j 可以从左边 (j-1) 走一步过来，也可以从右边 (j+1) 走一步过来
        //         // (j - 1 + length) % length：处理越界，比如 0-1 = -1，加上 10 取模后变成 9
        //         // (j + 1) % length：处理越界，比如 9+1 = 10，取模后变成 0
        //         dp[i][j] = dp[i - 1][(j - 1 + length) % length] + dp[i - 1][(j + 1) % length];
        //     }
        // }

        for (int i = 1; i <= n; i++) {
            int curr = i % 2;       // 当前行
            int prev = (i - 1) % 2; // 上一行
            
            for (int j = 0; j < length; j++) {
                dp[curr][j] = dp[prev][(j - 1 + length) % length] + dp[prev][(j + 1) % length];
            }
        }
        
        // 返回走 n 步最终在 0 点的方案数
        return dp[n][0];
    }
}