class Solution {
    // 相向双指针 通用方法
    // 前提是有序数组
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                break;
            } else if (numbers[left] + numbers[right] > target) {
                // left-right中间所有数字相加都大了，往小了缩减
                right--;
            } else {
                left++;
            }
        }
        return new int[] { left + 1, right + 1 };
    }

}