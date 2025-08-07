class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;


        // dp[i][j]代表以i,j为右下角的正方形的最大变长，正方形内部全是1
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // 为1 可以分情况讨论
                if(matrix[i][j] == '1'){
                    // i==0或者j=0的边界上 要么是0要么是1 变长就是1
                    if(i==0 || j==0){
                        dp[i][j] = matrix[i][j] - '0';
                    }else{
                        // 非边界上 取决于左边、左上、上边的三个正方形的最大边长的最小值
                        dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
                    }
                    ans = Math.max(dp[i][j], ans);
                }
                // 为0的话 dp[i][j] = 0 正方形内不能有0
            }       

        }
         return ans * ans;
    }
}