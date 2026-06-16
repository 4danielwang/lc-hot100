/**
 * @description: 计算[0,0]到[m-1,n-1]的不同路径数量,每次只能向下或者向右走1步
 *               动态规划(重要) 组合数学(最优解)
 *               dp[i][j] 表示从起点到(i,j)的不同路径数量
 *               dp[0][j]=1 dp[i][0]=1 在第一行和第一列只有一种路径
 *               使用滚动数组优化空间复杂度 f[i][j] = f[i-1][j] + f[i][j-1] 只与上一行和当前行有关
 */
class Solution {
    // 空间 O(mn) 空间O(n) m<=n
    // 滚动数组 优化空间
    public int uniquePaths(int m, int n) {
        // f[i][j] = f[i-1][j] + f[i][j-1] 上一行的正上方+当前行的左边
        int[] f = new int[n];
        for (int i = 0; i < n; ++i) {
            f[i] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                // 新的f[j] = 旧的f[j] + f[j-1]
                // 旧的f[j]是上一行的正上方, f[j-1]是当前行的左边
                f[j] += f[j - 1];
            }
        }
        return f[n - 1];
    }
}