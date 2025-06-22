class Solution {
    public int numIslands(char[][] grid) {
        // grid[i][j] 0代表水 1代表陆地 2代表访问过
        int num = 0;
        // 注意grid.length代表一维数组长度
        // grid[i].length代表 第二维数组长度
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i ,j);
                    num++;
                }
            }
        }        
        return num;
    }

    // 深度优先遍历grid
    private void dfs(char[][] grid, int i, int j){
        // 遇到水，边界，或者已经访问过的
        if(i< 0 || j<0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1')
        return ;
        grid[i][j] = '2';
        dfs(grid, i, j-1);
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
    }
}