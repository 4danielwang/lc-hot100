/**
 * @description: 最大子数组和：找出nums数组中连续子数组（至少1个元素）的最大和
 * 思路：动态规划 f(i) =  max(f(i-1)+nums[i], nums[i])，即以i结尾的最大子数组和，要么是前一个最大子数组和加上当前元素，要么是当前元素本身
 * 空间优化：滚动数组，f(i)只依赖于f(i-1)，所以可以用一个变量保存前一个最大子数组和
 */
class Solution {
    // 时间O(N) 空间O(1)
    public int maxSubArray(int[] nums) {
        // int[] f = new int[nums.length];  f[0] = nums[0];
        // pre表示f(i-1) maxAns表示f(i)的最大值
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            // f(i) =  max(f(i-1)+nums[i], nums[i])
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}