/**
 * @description 打家劫舍,不能偷窃相邻的房屋(会触发警报),求最大偷窃金额
 *              当在第i间房门口,小偷有两种选择:
 *              1. 偷窃第i间房屋,那么当前最高金额=走到i-2间房屋的最高金额+当前房屋金额
 *              2. 不偷窃第i间房屋,那么当前最高金额=走到i-1间房屋的最高金额
 *              dp[i] = max(dp[i-2] + nums[i], dp[i-1])
 *              利用滚动数组 优化空间:
 *              计算当前的dp[i],只与前两个状态有关dp[i-1]和dp[i-2],所以我们可以用两个变量来保存这两个状态,每次更新这两个变量即可
 */
class Solution {
    // 时间O(n) 空间O(1)
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        // 初始条件 dp[0] = nums[0], dp[1] = max(nums[0], nums[1])
        int prev2 = nums[0]; // prev2 相当于 dp[i-2]
        int prev1 = Math.max(nums[0], nums[1]); // prev1 相当于 dp[i-1]
        for (int i = 2; i < length; i++) {
            // current 相当于 dp[i]
            int current = Math.max(prev2 + nums[i], prev1);
            // 滚动更新，为下一次循环做准备
            prev2 = prev1;
            prev1 = current;
        }
        return prev1; // 返回dp[n-1]
    }
}
