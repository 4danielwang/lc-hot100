/**
 * @description: 接雨水:给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 思路：双指针。一个下标i位置的接水量，取决于i位置左边最高的柱子leftmax和右边最高的柱子rightmax，二者的较小值减去当前i位置的柱子高度
 */
class Solution {
    // 时间O(N) 空间O(1)
    public int trap(int[] height) {
        int ans = 0;
        // 双指针 从左往右移动left，计算leftMax，right反过来从右往左移动
        int left = 0, right = height.length - 1;
        // 左右柱子最高高度 接水量由左右柱子最高高度的较小值减去当前柱子高度决定
        int leftMax = 0, rightMax = 0;
        // 左右指针相遇停止
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            // 如果 height[left]<height[right]，则必有 leftMax<rightMax
            if (height[left] < height[right]) {
                // 计算left处的接水量：leftmax是较小的
                ans += leftMax - height[left];
                ++left;
            } else {
                // 如果 height[left]>=height[right]，则必有 rightMax<=leftMax
                // 计算right处的接水量：rightmax是较小的
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}