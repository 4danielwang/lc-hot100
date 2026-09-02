/**
 * @description: 在元素互不相同的旋转排序数组中寻找最小值
 * 思路：二分查找，旋转后分为两个有序段。比较nums[mid]和nums[right]的大小，每次缩减区间只保留较小的区间。
 * @example: [3,4,5,1,2] 旋转点是1，最小值是1
 * @example: [4,5,6,7,0,1,2] 旋转点是0，最小值是0
 */
class Solution {
    // 时间O(logn) 空间O(1)
    public int findMin(int[] nums) {
        // 闭区间二分查找
        int left=0;
        int right=nums.length-1;

        // 退出时 left=right
        while(left<right){
            int mid = left+(right-left)/2;
            
            // 如果nums[mid] > nums[right]，说明最小值一定在右边段，缩小0~mid的范围，搜索mid+1~right
            if(nums[mid] > nums[right])
                left=mid+1;
            // 最小值一定在左边段（包括也可能是mid），缩小mid~right的范围，搜索left~mid
            else
                right=mid;
        }
        return nums[left];
    }
}