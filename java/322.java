/**
 * @description: 从coins数组中选择数字硬币(数字可以无限重复选择)凑成amount,返回最少的币个数,如果不可能凑成amount,返回-1
 * @example: 输入: coins = [1, 2, 5], amount = 11 输出: 3
 * 空间优化: 滚动数组 f[i][j]只与f[i-1][j]和f[i][j-coins[i]]有关, 所以可以使用滚动数组(2行)优化空间复杂度
 * 思路: f[i][j]表示前coins[0...i]里面的硬币凑成金额j所需的最少硬币数
 */
class Solution {
    // 时间O(n*amount) 空间O(amount)
    public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            // int[][] f = new int[n + 1][amount + 1];
            int[][] f = new int[2][amount + 1];
            Arrays.fill(f[0], Integer.MAX_VALUE / 2); // 除 2 防止后面 + 1 溢出Integer
            
            f[0][0] = 0; // 初始条件
            // (i+1)%2表示当前行, i%2表示上一行
            for (int i = 0; i < n; i++) {
                for (int c = 0; c <= amount; c++) {
                    // 硬币比当前金额大,不能选择该硬币,只能继承上一个状态
                    if (c < coins[i]) {
                        // f[i][c] = f[i - 1][c];
                        f[(i + 1) % 2][c] = f[i % 2][c];
                    } else {
                        // 选择该硬币和不选择该硬币,取最小值
                        // f[i][c] = Math.min(f[i - 1][c], f[i][c - coins[i]] + 1);
                        f[(i + 1) % 2][c] = Math.min(f[i % 2][c], f[(i + 1) % 2][c - coins[i]] + 1);
                    }
                }
            }
            // 最后一行代入后是n%2 dp[n][amount]
            int ans = f[n % 2][amount];
            // 判断是否有解,如果没有解返回-1
            return ans < Integer.MAX_VALUE / 2 ? ans : -1;
        }
}