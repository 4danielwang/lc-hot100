/**
 * @description: 返回两个数组中公共的、长度最长的子数组长度
 * @example: 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7], 输出：3
 * 思路：动态规划，dp[i][j]表示以A[i:]和B[j:]最长公共前缀 dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0
 * 空间优化：滚动数组，dp[i][j]只依赖于dp[i + 1][j + 1]，可以用两行滚动更新
 */
class Solution {
    // 时间O(n*m) 空间O(m)
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;

        // 需要n + 1行 m + 1列，最后一行和最后一列都是0,因为初始计算dp[n-1][m-1]时，需要用到dp[n][m]，所以需要多一行和一列
        // int[][] dp = new int[n + 1][m + 1];
        int[][] dp = new int[2][m + 1]; // 滚动数组
        int ans = 0; 
        // 从dp[n][m]开始向前计算 最后计算dp[0][0]
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int cur = (i + 1) % 2; // 当前行 第一行要从n开始，所以i+1
                int next = i % 2; // 前一行
                dp[cur][j] = A[i] == B[j] ? dp[next][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[cur][j]);

                // dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                // ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}