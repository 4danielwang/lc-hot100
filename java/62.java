class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return dfs(m-1, n-1, memo);
    }

    // 子问题：dfs(i,j)等于求dfs(i-1,j)+dfs(i,j-1)
    // 边界：i<0||j<0
    // 边界 i=j=0
    // 记忆化搜索 减少重复计算
    private int dfs(int i, int j, int[][] memo){
        if(i<0 || j<0){
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        // 记忆化搜索
        if(memo[i][j] != 0){
            return memo[i][j];
        }
        return memo[i][j] = dfs(i-1,j,memo) + dfs(i,j-1,memo);
    }
}
class Solution {
    // 空间复杂度O(mn)
    public int uniquePaths(int m, int n) {
        // f[i][j] = f[i-1][j] + f[i][j-1]
        // 偏移 变成正的
        // f[i+1][j+1] = f[i][j+1] + f[i+1][j]
        int[][] f = new int[m+1][n+1];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){ // 与原来的方法保持一致 i=j=0是边界条件 需要单独处理
                    f[i+1][j+1] = 1;
                }else{
                    f[i+1][j+1] = f[i][j+1] + f[i+1][j];
                }
            }
        }
        return f[m][n];
    }
}

class Solution {

    // 空间复杂度O(n)
    public int uniquePaths(int m, int n) {
        // f[i][j] = f[i-1][j] + f[i][j-1]
        // f[i-1][j]上一行的元素 f[i][j-1]当前行的元素 与之前行的值都无关
        // 只需存当前行 滚动一维数组实现
        // f数组去掉第0维度 从上一个方法的代码直接改即可
        // f[j] = f[j] + f[j-1]
        int[] f = new int[n+1];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){ // 与原来的方法保持一致 i=j=0是边界条件 需要单独处理
                    f[j+1] = 1;
                }else{
                    f[j+1] = f[j+1] + f[j];
                }
            }
        }
        return f[n];
    }
}