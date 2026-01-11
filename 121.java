class Solution {
    // 时间O(n) 空间O(1)
    public int maxProfit(int[] prices) {
        // 盈利为最高价-最低价
        int ans = 0;
        // 买入股票需要最低价格
        int minPrice = prices[0];

        for(int price : prices){
            ans = Math.max(ans, price-minPrice); // 求最大的price-minPrice差值
            minPrice = Math.min(price, minPrice); // 更新最低的价格
        }
        return ans;
    }
}