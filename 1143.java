class Solution {
    public int longestCommonSubsequence(String text1, String text2) {   
        int m=text1.length();
        int n=text2.length();

        // dp[i][j]表示text1的0-i text2的0-j的LCS
        // 初始状态要多一个
        // dp[0][j]=dp[i][0]=0
        int dp[][] = new int[m+1][n+1];


        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                // 状态转移方程
                // dp[i][j] = dp[i-1][j-1] + 1 当dp[i-1] == dp[j-1]
                // dp[i][j] = dp[i-1][j], dp[i][j-1] 当dp[i-1] != dp[j-1]
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}