/**
 * @description: 买卖股票的最佳时机 II，根据股票价格数组，计算最大利润。可以多次卖出买入股票（同一时间只能持有1支股票）
 * 思路：只计算最大利润，可以使用贪心算法（每次选择贡献大于 0 的区间），累加利润。(如果得到交易过程的值，需要用动态规划)
 */
class Solution {
    // 时间O(n) 空间O(1)
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}

/**
 * 方法二：动态规划
 * dp[i][0]表示第i天不持有股票的最大利润，dp[i][1]表示第i天持有股票的最大利润
 * 状态转移方程：
 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i]) // 今天不持有股票，可能是昨天不持有，或者昨天持有股票今天卖出
 * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i]) // 今天持有股票，可能是昨天持有，或者昨天不持有今天买入
 */
class Solution {
    // 时间O(n) 空间O(n)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0; // 第0天不持有股票
        dp[0][1] = -prices[0]; // 第0天持有股票，买入价格为prices[0]
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0]; // 即最后一天不持有股票的最大利润
    }
}