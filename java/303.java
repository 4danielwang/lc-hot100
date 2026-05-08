class NumArray {
    private final int[] s;
    public NumArray(int[] nums) {
        s = new int[nums.length+1];
        s[0] = 0;
        for(int i=1;i<=nums.length;i++){
            s[i] = s[i-1] + nums[i-1];
        }
    }
    
    // 这里的left right是下标 前缀和数组的i代表前几个数 要+1
    // eg: left=,right=3
    public int sumRange(int left, int right) {
        // 前right+1个数的和-前left个数的和
        return s[right+1]-s[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */