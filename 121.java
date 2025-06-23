class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        
        // 记录i之前的最小价格
        int minPrice=prices[0];

        // 利润=prices[i]-minPrice
        // 求最大利润
        for(int i=0;i<prices.length;i++){
            ans = Math.max(ans, prices[i]-minPrice);
            // i之前的更新最小价格
            minPrice = Math.min(minPrice, prices[i]);
        }

        return ans;

    }
}