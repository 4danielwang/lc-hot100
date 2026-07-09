/**
 * @description: 两个字符串text1和text2的最长公共子序列(不改变顺序的情况下选择某些字符组成的新的子串)长度
 * @example: 输入: text1 = "abcde", text2 = "ace" 输出: 3
 * 空间优化: 滚动数组 dp[i][j]只与dp[i-1][j]和dp[i][j-1]有关, 所以可以使用滚动数组(2行)优化空间复杂度
 */
// 时间O(m*n) 空间O(n)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {   
        int m=text1.length();
        int n=text2.length();

        // dp[i][j]表示text1[0...i]和text2[0...j]的两个子串的LCS
        // dp[0][j]=dp[i][0]=0
        // int dp[][] = new int[m+1][n+1];
        int dp[][] = new int[2][n+1]; // 滚动数组

        // i%2表示当前行, (i-1)%2表示上一行
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                // 状态转移方程
                // dp[i][j] = dp[i-1][j-1] + 1 当dp[i-1] == dp[j-1]
                // dp[i][j] = dp[i-1][j], dp[i][j-1] 当dp[i-1] != dp[j-1]
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + 1;
                }else{
                    dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
                }
            }
        }
        // 返回dp[m][n]
        // 最后一行存储位置在m%2行
        return dp[m % 2][n];
    }
}