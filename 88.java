import java.util.*;
// 最优解 双指针法 时间O(m+n) 空间O(1)
class Solution {
    // 从右往左 把nums2合并到nums1中 大的放后面 从大到小
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 双指针法 时间O(m+n) 空间O(1)
        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;

        // 只要nums2合并完就算结束
        while(p2 >= 0){
            // nums1还有并且对比nums1和nums2
            // 把nums1[p1]放到最后的p位置
            if(p1 >=0 && nums1[p1] >= nums2[p2]){
                nums1[p--] = nums1[p1--]; 
            }else{ // 把nums2[p2]放到最后的p的位置
                nums1[p--] = nums2[p2--];
            }
        }
    }
}