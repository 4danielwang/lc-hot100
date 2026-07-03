/**
 * @description: 在数组中找到最小的连续子数组,使得其和大于等于target,返回其长度,如果不存在则返回0
 * @example: 输入: target = 7, nums = [2,3,1,2,4,3] 输出: 2([4,3])
 *           思路: 滑动窗口left,right是窗口指针,不断扩大右窗口如果超过了target再缩短左窗口,过程中更新最小数组长度
 */
class Solution {
    // 时间O(n) 空间O(1)
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        // ans为满足sum >= target的窗口 不断更新找到最小值
        // 初始化比数组长度大 代表没有符合条件的子数组
        int ans = n + 1;
        // 滑动窗口左右端点
        int left = 0;
        int right = 0;
        // 子数组元素和
        int sum = 0;

        // 枚举扩大右端点
        while (right < n) {
            sum += nums[right]; // 元素进入窗口
            // 缩小左端点
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        // 说明没找到符合条件的子数组
        return ans <= n ? ans : 0;
    }
}