class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;

        // 最后的退出情况就是left=right
        while(left<right){
            int mid = left+(right-left)/2;
            
            // 分两种情况 一个有序段 两个有序段
            // [1,2,3,4,5]
            // [3,4,5,1,2]
            //  情况1 两个有序段 mid在第一个段内
            if(nums[mid] > nums[right])
                left=mid+1;
            // 情况2 要么mid在第二个有序段 要么nums整体只有一个有序段
            // 包含了>=等于的情况 right不是更新为 mid+1而是mid
            else
                right=mid;
        }
        return nums[left];
    }
}