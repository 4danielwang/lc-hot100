class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length ==0){
            return new int[]{-1, -1};
        }
        // 下界
        int lo = lowerBound(nums, target);
        if(lo == nums.length || nums[lo] != target){
            return new int[]{-1, -1};
        }
        // 上界
        int hi = upperBound(nums, target);
        return new int[]{lo, hi};
    }

    // 计算>=target的最小元素下标
    private int lowerBound(int[] nums, int target){
        int left=0;
        int right=nums.length-1;

        // 采用左右闭区间[left, right]
        while(left<=right){
            int mid = left + (right-left) / 2;
            if(nums[mid] < target){
                left = mid + 1; // target应该在[mid+1, right]
            }else{ 
                right = mid -1; // target应该在[left, mid-1]
            }
        }
        return left; // 最终left指向第一个>=target的位置
    }

    private int upperBound(int[] nums, int target){
        int left=0;
        int right=nums.length-1;

        // 采用左右闭区间[left, right]
        while(left<=right){
            int mid = left + (right-left) / 2;
            if(nums[mid] <= target){
                left = mid + 1; // target应该在[mid+1, right]
            }else{ 
                right = mid -1; // target应该在[left, mid-1]
            }
        }
        return right; // 最终right指向最后一个<=target的位置
    }
}