class Solution {

    // leetcode 153 二分找到最小值的下标
    private int findMin(int[] nums, int target){
        int left=0;
        int right=nums.length-1;

        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid] > nums[right])
                left=mid+1;
            else
                right=mid;
        }
        return left;
    }
    
    // leetcode 34 找到>=最小值的下标
    // 没有找到 返回数组长度
    // nums是有序数组
    private int lowerBound(int[] nums, int left, int right, int target){

        while(left<=right){
            int mid=left+(right-left)/2;

            if(nums[mid] < target)
                left=mid+1;
            else if(nums[mid] > target)
                right=mid-1;
            else
                return mid;
        }
        // 根据题目要求 若search不到返回-1
        // 默认的话应该是返回left也就是数组长度的
        return -1;
    }

    public int search(int[] nums, int target) {
        // 最小值的下标
        int i = findMin(nums, target);
        // target在第一段中，在第一个有序数组查找
        if(target > nums[nums.length-1])
            return lowerBound(nums, 0, i-1, target);
        // target在第二段
        // nums为一个有序段（i=0)
        // 都在[i, n-1]查找
        else
            return lowerBound(nums, i, nums.length-1, target);

    }
}