class Solution {

    // DFS
    public boolean exist(char[][] board, String word) {
        char[] ar = word.toCharArray();
        boolean[][] visited = new boolean[board.length][];
        for(int i=0;i<board.length;i++){
            visited[i] = new boolean[board[i].length];
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                // 找第一个字母相等的地方 开始dfs
                if(ar[0] == board[i][j]){
                    if(dfs(i, j, board, 0, ar, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, int depth, char[] ar, boolean[][] visited){
        // 边界判断
        if(i>=board.length || i<0 || j>=board[i].length || j<0){
            return false;
        }
        // 已经访问过 或者字母匹配不上
        if(visited[i][j] || board[i][j] != ar[depth]){
            return false;
        }
        // 长度足够得到答案
        if(depth == ar.length-1){
            return true;
        }
        visited[i][j]=true;

        // 从四个方向dfs找子问题答案
        boolean found = dfs(i+1,j,board,depth+1,ar,visited) ||
                        dfs(i,j+1,board,depth+1,ar,visited) || 
                        dfs(i-1,j,board,depth+1,ar,visited) || 
                        dfs(i,j-1,board,depth+1,ar,visited);

        // 回溯
        visited[i][j]=false;
        return found;
    }
}