class Solution {
    public int maxProfit(int[] prices) {
        return solution2(prices);
    }

    // 把有每日收益加起来
    // price[i] < price[i+1] 就有收益
    private int solution1(int[] prices){
        int ans = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i-1] < prices[i]){
                ans+=(prices[i] - prices[i-1]);
            }
        }
        return ans;
    }

    // dp[n][2] 表示总收益
    // dp第一个维度：第i天结束了
    // dp第二个维度：手里是否有股票
    // 分情况讨论dp[i]
        // dp[i][0]： 前一天也没股票，收益没变化；前一天有股票，收入+prices[i]
        // dp[i][1]：前一天有股票，收益没变化；前一天没股票，收入-prices[i]
    // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i]) 前一天也没股票，或者前一天有股票两种情况
    // dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
    private int solution2(int[] prices){
        int n = prices.length;
        int dp[][] = new int[n][2];
        dp[0][1] = -prices[0];
    
        for(int i=1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        } 

        // dp[n-1][0] 卖掉股票收入是最多的
        return dp[n-1][0];
    }

    // 由于dp[i][]只与dp[i-1][]两个值相关
    // 空间优化： 用两个变量dp1,dp2分别替代dp[i-1][0], dp[i-1][1]
    private int solution3(int[] prices){
        int n = prices.length;
        int dp[][] = new int[n][2];

        int dp1 = 0, dp2 = -prices[0];
        for(int i=1;i<n;i++){
            int newDp1 = Math.max(dp1, dp2 + prices[i]);
            int newDp2 = Math.max(dp2, dp1 - prices[i]);
            
            dp1 = newDp1;
            dp2 = newDp2;
        } 

        return dp1;
    }
}


class Solution {
    // 时间O(n) 空间O(1)
    // 贪心： 找到x个不相交的区间(l,r] 最大化区间的收益
        // 问题转换：求每个长度为1的区间的最大价值 把所有>0的累加起来即可
    public int maxProfit(int[] prices) {
        int ans = 0;

        for(int i=0;i<prices.length-1;i++){
            ans += Math.max(0, prices[i+1]-prices[i]);
        }
        return ans;
    }
}

class Solution {
    // 动态规划: dp表示当前最大收益 股票卖出后才有收益
    // 时间O(n) 空间O(1)
    public int maxProfit(int[] prices) {
        
        int [][]dp = new int[prices.length][2];
        // dp0表示第i天交易完后 没有股票情况
        // dp1表示第i天交易完后 持有股票情况
        int dp0 = 0; // 第一天没买股票
        int dp1 = -prices[0]; // 第一天买了股票 亏损

        for(int i=1;i<prices.length;i++){
            // 收益最大化
            int _dp0 = Math.max(dp0, dp1 + prices[i]);
            int _dp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = _dp0;
            dp1 = _dp1;
        }
        // 因为最大化收益dp1一定比dp0小 
        // 只有手里没股票 才是最大收益
        return dp0;
    }
}