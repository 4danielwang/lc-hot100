/**
 * @description: LIS最长递增子序列： 找到nums数组中严格递增的子序列（可以删除数组元素但不能改变顺序）最大的长度
 * 思路: 贪心 + 二分。递增子序列尽可能的长，就需要末尾的元素越小越好，增长速度尽可能的慢。tails数组记录不同长度的LIS的最小结尾元素，tails[i]表示长度为i+1的LIS的最小结尾元素
 * 空间优化：复用nums数组作为tails数组，原地修改来记录不同长度的LIS的最小结尾元素
 */
class Solution {
    // 时间O(nlogn) 空间O(1)
    public int lengthOfLIS(int[] nums) {
        // int[] tails = new int[nums.length];
        int res = 0; // LIS的长度
        for (int x : nums) {
            // 二分查找找到第一个>=x的位置
            int j = lowerBound(nums, res, x);
            // 贪心：直接用当前更小的，替换掉原来更大的那个元素
            nums[j] = x;
            // x比tails中所有元素都大，LIS长度增加1
            if (j == res) {
                res++;
            }
        }
        return res;
    }

    // 在tails数组中进行二分查找：len表示当前tails数组的长度（LIS长度），返回第一个>=target的位置
    private int lowerBound(int[] nums, int len, int target) {
        // 开区间写法
        // 循环不变量：left一定<target, right一定>=target
        int left = -1; 
        int right = len;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid; // 范围缩小到 (mid, right)
            } else {
                right = mid; // 范围缩小到 (left, mid)
            }
        }
        return right; // 循环结束后返回right（第一个>=target的位置）
    }
}