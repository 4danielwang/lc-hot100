class Solution {

    // 通过dfs 计算所有的连通区域的面积和
    // grid[i][j] 0表示水面 1表示陆地 -1表示已经访问过该土地
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // 是陆地 开始求面积
                if(grid[i][j] == 1){
                    ans = Math.max(ans, dfs(i,j,grid));
                }
            }
        }
        return ans;

    }

    // 找到从i,j起点的最大岛屿面积
    private int dfs(int i, int j, int[][] grid){

        // 越界 or 不是土地
        if(i<0 || j<0 || i==grid.length || j==grid[0].length || grid[i][j] != 1){
            return 0;
        }

        // 当前岛屿面积
        int ans=1;
        // 访问过的土地 设为-1
        grid[i][j] = -1;

        // 计算相邻四个点 做为起点的岛屿面积
        ans += dfs(i-1,j,grid);
        ans += dfs(i+1,j,grid);
        ans += dfs(i,j+1,grid);
        ans += dfs(i,j-1,grid);
        return ans;
    }
}