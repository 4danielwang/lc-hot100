class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // 完全背包问题
        int memo[][] = new int[n][amount+1];
        // i表示当前剩余的币个数 c表示剩余额度
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1); // fill填充一维数组
        }
        int ans = dfs(n - 1, amount, coins, memo);// 从末尾开始 从大到小的用币
        return ans < Integer.MAX_VALUE / 2? ans : -1;
    }

    /**
      * i：当前币的位置
      * c：剩余要凑的金额
      * return：币的数量
     */
    private int dfs(int i, int c, int[] coins, int[][]memo){
        // 没有币了
        if(i < 0){
            if(c==0) return 0; // 刚好用完
            else return Integer.MAX_VALUE / 2; // 防止dfs+1溢出
        }
        // 记忆化搜索
        if(memo[i][c] != -1){
            return memo[i][c];
        }
        // 只能不选当前币
        if(c < coins[i]){
            return memo[i][c] = dfs(i-1, c, coins, memo);
        }
        // 不选当前币了
        // 选了并且继续选
        return memo[i][c] = Math.min(dfs(i-1, c, coins, memo), dfs(i, c-coins[i], coins, memo) + 1);

    }
}