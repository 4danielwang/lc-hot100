class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols]; // 记录访问过的元素
        List<Integer> ans = new ArrayList<>();
        
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}}; // 访问方向
        int directionIdx = 0; // 当前方向索引

        // 数组空返回
        if(matrix == null || rows == 0 || cols == 0)
            return ans;
        
        int row=0;
        int col=0;

        int total = rows*cols;
        for(int i=0;i<total;i++){
            ans.add(matrix[row][col]);
            visited[row][col] = true;
            // 看一下下一个节点
            int nextrow = row+directions[directionIdx][0], nextcol = col+directions[directionIdx][1];
            // 到边界了 或者访问过了 换方向
            if(nextrow < 0 || nextrow>=rows || nextcol<0 || nextcol >=cols || visited[nextrow][nextcol])
                directionIdx = (directionIdx+1)%4;
            row += directions[directionIdx][0];
            col += directions[directionIdx][1];
                
        }

        return ans;
    }
  
}