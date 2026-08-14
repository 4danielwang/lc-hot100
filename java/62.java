/**
 * @description: 计算[0,0]到[m-1,n-1]的不同路径数量,每次只能向下或者向右走1步
 *               动态规划(重要) 组合数学(最优解)
 *               dp[i][j] 表示从起点到(i,j)的不同路径数量
 *               dp[0][j]=1 dp[i][0]=1 在第一行和第一列只有一种路径
 *               使用滚动数组优化空间复杂度 f[i][j] = f[i-1][j] + f[i][j-1] 只与上一行和当前行有关 上一行的正上方+当前行的左边
 */
class Solution {
    // 空间 O(mn) 空间O(n) m<=n
    // 滚动数组 优化空间
    public int uniquePaths(int m, int n) {
        // int[][] f = new int[m][n];
        // 滚动数组 2行
        int[][] f = new int[2][n];

        // 初始化第一列
        // for(int i=0; i<m; i++){
        //     f[i][0] = 1;
        // }

        // 初始化第一行
        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }

        // for(int i = 1; i < m; i++) {
        //     for (int j = 1; j < n; j++) {
        //         f[i][j] = f[i - 1][j] + f[i][j - 1];
        //     }
        // }
        // return f[m - 1][n - 1];



        for (int i = 1; i < m; ++i) {
            int curr = i % 2; // 当前行
            int prev = (i - 1) % 2; // 上一行
            // 滚动数组 需要初始化当前行的第一个元素
            f[curr][0] = 1;
            for (int j = 1; j < n; ++j) {
                f[curr][j] = f[prev][j] + f[curr][j - 1];
            }
        }
        return f[(m - 1) % 2][n - 1];
    }
}