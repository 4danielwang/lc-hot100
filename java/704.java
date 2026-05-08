class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length-1, nums, target);
    }

    // 二分查找逻辑
    // 等于返回，小于左边递归 大于右边递归
    // 这里规定左右都是闭区间
    private int binarySearch(int left, int right, int[] nums, int target){
        if(left>right){
            return -1;
        }

        int mid = left + (right-left) / 2;
        if(nums[mid] == target){
            return mid;
        }else if(target > nums[mid]){
            return binarySearch(mid+1, right, nums, target);
        }else{
            return binarySearch(left, mid-1, nums,target);
        }
    }
}