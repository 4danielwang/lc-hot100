/**
 * @description 两个非递减数组nums1（元素m，总长度m+n)和nums2(长度n)合并到nums1中，合并后保持非递减
 * @example: 输入：[1,2,3,0,0,0], m = 3, [2,5,6], n = 3 输出: [1,2,2,3,5,6]、
 * 思路：逆向双指针
 */
class Solution {
    // 时间O(m+n) 空间O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; // nums1的指针
        int p2 = n - 1; // nums2的指针
        int p = m + n - 1; // 合并后的位置指针
        while (p2 >= 0) { // nums2 还有要合并的元素
            // 如果 p1 < 0，那么走 else 分支，只剩下nums2没合并继续合并
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--]; // 填入 nums1[p1]
            } else {
                nums1[p--] = nums2[p2--]; // 填入 nums2[p1]
            }
        }
    }
}