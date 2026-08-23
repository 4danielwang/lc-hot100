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