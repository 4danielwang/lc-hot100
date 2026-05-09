/**
 * @description: 接雨水:给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
// 一个下标i位置的接水量，取决于i位置左边最高的柱子和右边最高的柱子，二者的较小值减去i位置的柱子高度
class Solution {
    // 时间O(N) 空间O(1)
    public int trap(int[] height) {
        int ans = 0;
        // 双指针
        int left = 0, right = height.length - 1;
        // 左右柱子最高高度
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}