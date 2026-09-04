/**
 * @description: 区域和检索
 * 思路：提前计算前缀和
 */
class NumArray {
    // 时间O(n) 空间O(n)
    private final int[] s;
    public NumArray(int[] nums) {
        // s[i]表示前i个数的和
        s = new int[nums.length+1];
        s[0] = 0;
        for(int i=1;i<=nums.length;i++){
            s[i] = s[i-1] + nums[i-1];
        }
    }
    
    // 这里的left right是下标 前缀和数组的i代表前几个数 要+1
    public int sumRange(int left, int right) {
        // 前right+1个数的和-前left个数的和
        return s[right+1]-s[left];
    }
}