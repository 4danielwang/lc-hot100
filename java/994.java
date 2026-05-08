class Solution {
    // 存储四个方向的偏移量 当需要往四个方向走 直接用坐标+坐标偏移
    private static final int[][] OFFSET = {{-1,0},{1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int fresh = 0; // 统计剩下的新鲜橘子个数
        Queue<int[]> pre = new LinkedList<>(); // 烂橘子队列 每个元素都保存的是烂橘子的坐标(i,j)

        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j] == 2){
                    pre.add(new int[]{i,j});
                }
            }
        }    
        
       
        int ans=0;  // 走过的最大分钟数(dfs层数)
        while(fresh>0 && !pre.isEmpty()){ // 需要通过fresh 避免fresh=0 pre不为空的时候 还会多一轮循环
            ans++;
            Queue<int[]> next = new LinkedList<>(); // 访问当前队列
            for(int[] pos: pre){
                for(int[] offset : OFFSET){
                    int i = pos[0] + offset[0];
                    int j = pos[1] + offset[1];
                    if(i>=0 && i<m && j>=0 && j<n && grid[i][j] == 1){ // 更新fresh,grid,next
                        grid[i][j] = 2;
                        next.add(new int[]{i,j});
                        fresh--;
                    }
                }                
            }
            pre=next;
        }

        
        // 结果是队列为空 fresh不为0
        return fresh>0?-1:ans; // 有多个联通分量 无法通过一次dfs访问到
    }

}