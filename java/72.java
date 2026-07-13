/**
 * @description: 计算两个单词word1和word2的编辑距离（允许对word1单词进行3种操作，变为word2需要的最少操作次数）
 * 三种操作：在word1种插入一个字符、在word2种插入一个字符、在word1中修改一个字符
 * dp[i][j]表示word1的前i个字符和word2的前j个字符的编辑距离 dp[i][j] = min(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+(word1[i]==word2[j]?0:1))
 * 空间优化： dp[i][j]只与dp[i-1][j], dp[i][j-1], dp[i-1][j-1]3个值2行有关，所以可以使用滚动数组优化空间复杂度
 */
class Solution {
    // 时间O(mn) 空间O(m)
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }

        // DP 数组
        // int[][] D = new int[n + 1][m + 1];
        int[][] D = new int[2][m + 1]; // 空间优化：只需要 2 行的空间即可

        // 边界状态初始化
        // for (int i = 0; i < n + 1; i++) {
        //     D[i][0] = i;
        // }
        //  for (int j = 0; j < m + 1; j++) {
        //     D[0][j] = j;
        // }
        
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        // for (int i = 1; i < n + 1; i++) {
        //     for (int j = 1; j < m + 1; j++) {
        //         int left = D[i - 1][j] + 1;
        //         int down = D[i][j - 1] + 1;
        //         int left_down = D[i - 1][j - 1];
        //         if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
        //             left_down += 1;
        //         }
        //         D[i][j] = Math.min(left, Math.min(down, left_down));
        //     }
        // }
        // return D[n][m];

        // 用 i % 2 表示当前计算的行，(i - 1) % 2 表示上一行。
        for (int i = 1; i < n + 1; i++) {
            int curr = i % 2;
            int prev = (i - 1) % 2;

            // 每一行计算前，先初始化这一行的第一个值
            D[curr][0] = i; 

            for (int j = 1; j < m + 1; j++) {
                int left = D[curr][j - 1] + 1; // 对应 D[i][j - 1] + 1
                int down = D[prev][j] + 1; // 对应 D[i - 1][j] + 1
                int left_down = D[prev][j - 1]; // 对应 D[i - 1][j - 1]
                
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                
                // 取三种操作的最小值
                D[curr][j] = Math.min(left, Math.min(down, left_down));
            }
        }

        // 返回时，取第 n 行所在的滚动数组索引：n % 2
        return D[n % 2][m];
    }
}