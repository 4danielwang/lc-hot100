import java.util.*;

class Solution {
    public int minDistance(String word1, String word2) {
        // i j从末尾开始
        int m = word1.length() - 1;
        int n = word2.length() - 1;
        return dfs(m, n, word1.toCharArray(),word2.toCharArray());
    }

    private int dfs(int i, int j, char[] ar1, char[] ar2){
        // 字符串只有1个 返回
        if(i<0)
            return j+1;
        if(j<0)
            return i+1;

        // 递归三种情况
        // 1，ar1[i] == ar2[j] i和j都去掉
        if(ar1[i] == ar2[j])
            return dfs(i-1, j-1, ar1, ar2);
        
        // 2，删除 插入到ar1[i] 使得ar1[i]==ar2[j] 等价于删除了ar2[j] 
        // 3，插入 插入到ar2[j] 使得ar1[i]==ar2[j] 
        // 4. 替换
        return Math.min(dfs(i-1, j-1, ar1, ar2), Math.min(dfs(i, j-1, ar1, ar2), dfs(i-1, j, ar1, ar2))) + 1;
    }
}