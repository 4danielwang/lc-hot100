class Solution {


    // 动态规划 递归写法
    // grid[i][j]是从左上角到[i][j]的最小路径和 来源只能是上面或者左边
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 记忆化数组
        int[][] memo = new int[m][n];
        // 初始化内部数组
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        
        // 需要找到到最右下角的最小路径和
        return dfs(m-1, n-1, grid, memo);
    }

    /**
      * i,j 当前横纵下标
      * memo: 保存记忆 减少递归次数
     */
    private int dfs(int i, int j, int[][] grid, int[][] memo){
        // 超过边界 直接返回最大值
        if(i<0 || j<0){
            return Integer.MAX_VALUE;
        }
        // 左上角 起点值
        if(i==0 && j==0){
            return grid[i][j];
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }
        // 保存记忆
        return memo[i][j] = Math.min(dfs(i-1, j, grid, memo),dfs(i,j-1,grid,memo)) + grid[i][j];
    }
}