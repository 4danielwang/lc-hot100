/**
 * @description: 计算矩阵中的最长递增路径。相邻的两个单元格之间存在一条从较小值指向较大值的有向边，转化成在有向图中寻找最长路径
 * DFS+记忆化搜索
 */
class Solution {
    // 定义四个方向的偏移量：上、下、左、右
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        m = matrix.length;
        n = matrix[0].length;
        int[][] memo = new int[m][n]; // 备忘录
        int maxLength = 0; // 记录全局最长路径

        // 把每一个格子都当作起点尝试一遍
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 更新全局最大值
                maxLength = Math.max(maxLength, dfs(matrix, i, j, memo));
            }
        }
        return maxLength;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        // 1. 查备忘录，如果算过了直接返回，避免重复计算（核心优化）
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        // 当前格子本身算 1 步
        int max = 1; 

        // 2. 探索四个方向
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];

            // 判断边界条件，并且必须是"严格递增"才能走
            if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n 
                && matrix[nextI][nextJ] > matrix[i][j]) {
                
                // 递归计算下一步的最长路径，并加 1 (加上当前格子)
                max = Math.max(max, dfs(matrix, nextI, nextJ, memo) + 1);
            }
        }

        // 3. 将结果记录到备忘录，并返回
        memo[i][j] = max;
        return max;
    }
}