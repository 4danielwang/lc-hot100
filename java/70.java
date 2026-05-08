class Solution {
    
    
    public int climbStairs(int n) {
        if(n==1 || n==2){
            return n;
        }

        // 当n>2 动态规划
        int[] dp = new int[n]; // dp[i]爬到i的方法数
        dp[0] = 1;
        dp[1] = 2;

        for(int i=2;i<n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        } 
        return dp[n-1];
    }

}