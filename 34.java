class Solution {
    // 辅助函数，查找大于等于x的最小下标
    // 如果都小于x 返回数组长度
    // 失败情况1：返回数组长度，没找到
    // 失败情况2：返回的是一个index，left>right 也没找到
    private int lowerBound(int[] nums, int target){
        // 利用二分查找
        int left=0;
        int right=nums.length-1;
        // 结束条件 left>right
        while(left<=right){
            int mid = left+(right-left)/2; // 防止溢出
            // [left,mid] < target
            // [mid+1,right] >= target
            if(nums[mid] < target)
                left=mid+1;
            else
                right=mid-1;
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        int low = lowerBound(nums, target);
        // 判断两种失败情况
        if(low == nums.length || nums[low] != target) return new int[]{-1, -1};
        int high = lowerBound(nums, target+1) -1;
        return new int[]{low, high};
    }
}