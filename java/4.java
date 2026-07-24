/**
 * @description: 寻找两个正序数组的中位数,两个有序数组nums1和nums2,找到中位数
 * 思路: 二分,找到第k大的元素,每次排除不符合条件的一半数组
 */
class Solution {
    // 时间复杂度O(log(m+n)) 空间复杂度O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        // 两个数组总长度
        int totalLength = length1 + length2;
        // 数组长度为奇数的中位数是第totalLength/2+1小的数,偶数的中位数是第totalLength/2和totalLength/2+1小的数的平均值
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    // 要在两个有序数组中找到第k小的元素，最快的办法是每次排除掉k/2个不可能的元素
    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        // 双指针
        int index1 = 0, index2 = 0;

        while (true) {
            // 边界: nums1到达末尾
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            // 边界: nums2到达末尾
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            // 边界: k=1,返回两个数组中最小的那个
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            
            int half = k / 2;
            // 注意边界,如果数组长度不够k/2,就取数组最后一个元素
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            // 比较nums1和nums2的第k/2个元素,根据数学证明,哪边小就排除哪个数组中当前index及其左边的元素
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            // 如果pivot1 <= pivot2,排除pivot1及其左边的元素,否则排除pivot2及其左边的元素
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1); // 排除掉的元素个数
                index1 = newIndex1 + 1; // 极端情况就是到达边界 == length1
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}