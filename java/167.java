/**
 * @description: 有序数组两数之和，返回两个数的序号，数组从1开始计数
 * 思路：相向双指针，前提是有序数组
 */
class Solution {
    // 时间O(n) 空间O(1)
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[] { left + 1, right + 1 };
            } else if (numbers[left] + numbers[right] < target) {
                // left-right中间所有数字相加都小了，往大了缩减
                left++;
            } else {
                // left-right中间所有数字相加都大了，往小了缩减
                right--;
            }
        }
        return new int[] {-1, -1};
    }

}