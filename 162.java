class Solution {

    public int findPeakElement(int[] nums) {
        int left=0;
        // 倒数第二个元素
        int right=nums.length-2; // 峰值元素一定存在,数组一定有左右元素

        // 退出条件left=right+1
        while(left <= right){
            int mid = left + (right -left )/2;
            if(nums[mid] < nums[mid+1])// 上坡 峰值在mid右边
                left=mid+1;
            else // 下坡 峰值在mid左边
                right=mid-1;
        }
        return left;
    }
}