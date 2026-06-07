/**
 * @description: 找到nums数组中严格递增的子序列（可以删除数组元素但不能改变顺序）最大的长度
 * @method: 贪心 + 二分
 */
class Solution {
    // 时间O(nlogn) 空间O(1)
    public int lengthOfLIS(int[] nums) {
        // LIS的长度
        int ng = 0;
        for (int x : nums) {
            // nums[0...ng-1]中查找第一个>=x的元素位置j
            int j = lowerBound(nums, ng, x);
            // 贪心：直接用当前更小的，替换掉原来更大的那个元素
            nums[j] = x;
            // 这种情况说明x比nums[0...ng-1]都大，LIS长度增加1
            if (j == ng) {
                ng++;
            }
        }
        return ng;
    }

    // 开区间写法
    private int lowerBound(int[] nums, int right, int target) {
        // 开区间初始条件和结束条件
        int left = -1; 
        while (left + 1 < right) {
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid; // 范围缩小到 (mid, right)
            } else {
                right = mid; // 范围缩小到 (left, mid)
            }
        }
        return right; // 循环结束后right就是第一个>=target的位置
    }
}