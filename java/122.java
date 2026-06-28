/**
 * @description: 买卖股票的最佳时机 II，根据股票价格数组，计算最大利润。可以多次卖出买入股票（同一时间只能持有1支股票）
 * @extra：对比买卖股票的最佳时机 I，只能买卖一次
 *                    动态规划: dp[i][0] / dp[i][1] 表示第i天交易完后 没有/有股票情况
 *                    1. dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
 *                    前一天也没股票，或者前一天有股票但卖出两种情况
 *                    2. dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
 *                    前一天有股票，或者前一天没股票但买入两种情况
 *                    空间优化:dp[i][0/1]只与两个值相关，利用滚动变量
 */

// 动态规划
class Solution {
    // 时间O(n) 空间O(1)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // prev2表示没有股票，prev1表示有股票
        int prev2 = 0, prev1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newPrev2 = Math.max(prev2, prev1 + prices[i]);
            int newPrev1 = Math.max(prev1, prev2 - prices[i]);
            prev2 = newPrev2;
            prev1 = newPrev1;
        }
        // 最后一天交易完后没有股票的最大利润
        return prev2;
    }
}

// 贪心
class Solution {
    // 时间O(n) 空间O(1)
    // 贪心： 找到x个不相交的区间(l,r] 最大化区间的收益
    // 问题转换：求每个长度为1的区间的最大价值(所有相邻区间>0的值)
    public int maxProfit(int[] prices) {
        int ans = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            ans += Math.max(0, prices[i + 1] - prices[i]);
        }
        return ans;
    }
}
