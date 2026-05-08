class Solution {

    // 两轮扫描
    // 找到第一个a[i]< a[i+1]的数字i， [i+1,n]一定是严格递减
    // 找到[i-n]中比他大的数字j
    // 交换i和j，把原来的i之后的元素翻转，[i+1,n]变为严格递增
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n <2){
            return;
        }
        
        // 找i的位置
        int i=n-2;
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        // 没找到i
        if(i<0){
            reverse(nums, 0, n-1);
            return;
        }
        
        // 找j
        int j=n-1;
        while(j>=i && nums[j]<= nums[i]){
            j--;
        }

        // 交换i和j
        swap(nums, i, j);
        // 翻转子数组【i+1,n】
        reverse(nums, i+1, n-1);
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int left, int right){
        while(left<right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}