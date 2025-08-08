class Solution {
    public int findPeakElement(int[] nums) {
        // [left... peek ... right]        
        // 二分查找 查找结束就是结果位置
        // 局部是上升的 往右找
        // 局部是下降的 往左找
        
        // 二分 左右都是闭区间
        int left=0;
        int right=nums.length-1;

        // 结束条件是left=right
        while(left<right){
            int mid = left + (right-left)/2;
            // mid是局部最大值 right包含了可能的最大值
            if(nums[mid] > nums[mid+1]){
                right=mid; 
            }else{
                left=mid+1;
            }
        }
        // 最后区间只剩一个值 返回谁都行
        return left;
    }
}
