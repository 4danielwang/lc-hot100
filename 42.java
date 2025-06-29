import java.util.*;

class Solution {
    private char[] ar1,ar2;
    private int[][] memo; // 是否已经计算过 记忆化搜索
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        ar1 = word1.toCharArray();
        ar2 = word2.toCharArray();
        memo = new int[m][n];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }

        return dfs(m-1, n-1);
    }

    private int dfs(int i, int j){
        // 字符串只有1个 返回
        if(i<0)
            return j+1;
        if(j<0)
            return i+1;
        
        if (memo[i][j] != -1) { // 之前算过了
            return memo[i][j];
        }

        // 递归三种情况
        // 1，ar1[i] == ar2[j] i和j都去掉
        if(ar1[i] == ar2[j])
            return memo[i][j] = dfs(i-1, j-1);
        
        // 2，删除 插入到ar1[i] 使得ar1[i]==ar2[j] 等价于删除了ar2[j] 
        // 3，插入 插入到ar2[j] 使得ar1[i]==ar2[j] 
        // 4. 替换
        return memo[i][j] = Math.min(dfs(i-1, j-1), Math.min(dfs(i, j-1), dfs(i-1, j))) + 1;
    }
}