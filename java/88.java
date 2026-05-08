class Solution {
    // 时间O(m+n) 空间O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p2 >= 0) { // nums2 还有要合并的元素
            // 如果 p1 < 0，那么走 else 分支，把 nums2 合并到 nums1 中
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--]; // 填入 nums1[p1]
            } else {
                nums1[p--] = nums2[p2--]; // 填入 nums2[p1]
            }
        }
    }
}