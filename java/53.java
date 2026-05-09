/**
 * @description: 找出nums数组中连续子数组（至少1个元素）的最大和
 */
class Solution {
    // 时间O(N) 空间O(1)
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        // 连续子数组 nums[i...j]的元素和=nums[0...j]元素和-nums[0...i-1]元素和，转换为两个前缀和的差
        // 求连续子数组最大，nums[0...i-1]前缀和最小即可
        int minPreSum = 0; // 最小前缀和
        int preSum = 0; // 当前的前缀和
        for (int x : nums) {
            preSum += x;
            ans = Math.max(ans, preSum - minPreSum); // 减去前缀和的最小值
            minPreSum = Math.min(minPreSum, preSum); // 维护前缀和的最小值
        }
        return ans;
    }
}